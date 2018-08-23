/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/8/19
 */
public class AsyncSocketTest {


    private final CharsetDecoder decoder = Charset.forName("GBK").newDecoder();
    private AsynchronousChannelGroup channelGroup;

    public AsyncSocketTest() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
    }

    public void start() {
        try {
            AsynchronousSocketChannel connector =  AsynchronousSocketChannel.open(channelGroup);
            connector.setOption(StandardSocketOptions.TCP_NODELAY, true);
            connector.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            connector.setOption(StandardSocketOptions.SO_KEEPALIVE, true);

            connector.connect(new InetSocketAddress("127.0.0.1", 91),
                    connector, new AioConnectHandler(3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
