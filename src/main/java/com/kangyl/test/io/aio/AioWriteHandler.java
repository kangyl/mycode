/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/19
 */
public class AioWriteHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socket;

    public AioWriteHandler(AsynchronousSocketChannel socketChannel) {
        this.socket = socketChannel;
    }

    @Override
    public void completed(Integer i, ByteBuffer buf) {
        if (i > 0) {
            socket.write(buf, buf, this);
        } else if (i == -1) {
            try {
                System.out.println("对端断线:" + socket.getRemoteAddress().toString());
                buf = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        exc.printStackTrace();
    }
}
