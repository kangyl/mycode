/**
 * Copyright
 */
package com.kangyl.test.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/9/6
 */
public class NettyClientDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClientDemo.class);

    public void start(String host, int port) {

        try {

            EventLoopGroup eventEvent = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventEvent);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new HttpResponseDecoder());
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    ch.pipeline().addLast(new HttpClientInboundHandler());
                }
            });

            ChannelFuture future = bootstrap.connect(host, port).sync();
            URI uri = new URI("http://"+host + ":" + port);
            String msg = "来自客户端的问候";
            System.out.println(msg);

            DefaultFullHttpRequest httpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,
                    uri.toASCIIString(), Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));
            httpRequest.headers().set(HttpHeaders.Names.HOST, host);
            httpRequest.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
            httpRequest.headers().set(HttpHeaders.Names.CONTENT_LENGTH, httpRequest.content().readableBytes());

            future.channel().write(httpRequest);
            future.channel().flush();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    public static void main(String[] args) {

        NettyClientDemo clientDemo = new NettyClientDemo();
        clientDemo.start("127.0.0.1", 9999);

    }
}
