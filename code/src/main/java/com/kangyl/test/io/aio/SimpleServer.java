/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/22
 */
public class SimpleServer {

    public SimpleServer() throws IOException {
        final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open();
        listener.bind(new InetSocketAddress(91));

        listener.accept(listener, new SimpleAcceptHandler());

    }


}
