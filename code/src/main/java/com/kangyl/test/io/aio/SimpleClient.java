/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/22
 */
public class SimpleClient {

    private AsynchronousSocketChannel client;

    public SimpleClient() throws IOException, InterruptedException, ExecutionException {
        this.client = AsynchronousSocketChannel.open();
        client.connect(new InetSocketAddress("127.0.0.1", 91),client,new SimpleConnectHandler());
    }

}
