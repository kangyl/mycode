/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/22
 */
public class SimpleConnectHandler implements CompletionHandler<Void, AsynchronousSocketChannel> {

    @Override
    public void completed(Void result, AsynchronousSocketChannel attachment) {
        ByteBuffer byteBuffer = ByteBuffer.wrap("这条信息来自客户端".getBytes());
        attachment.write(byteBuffer);
    }

    @Override
    public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
        exc.printStackTrace();
    }
}
