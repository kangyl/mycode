/**
 * Copyright
 */
package com.kangyl.test.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/9/6
 */
public class HttpClientInboundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpResponse) {
            HttpResponse response = (HttpResponse) msg;
            System.out.println("客户端接收服务器端返回的内容类型:" + response.headers().get(HttpHeaders.Names.CONTENT_TYPE));
        }
        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            ByteBuf buf = content.content();
            System.out.println("客户端接收服务器端返回的内容：" + buf.toString(io.netty.util.CharsetUtil.UTF_8));
            buf.release();
        }

    }
}
