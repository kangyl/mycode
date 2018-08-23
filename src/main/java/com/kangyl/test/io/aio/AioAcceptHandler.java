/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;


import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/19
 */
public class AioAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("waiting....");
        byteBuffer.clear();
        try {
            //把socket中的数据读取到buffer中
            result.read(byteBuffer).get();
            byteBuffer.flip();
            System.out.println("Echo " + new String(byteBuffer.array()).trim() + " to " + result);

            //把收到的直接返回给客户端
            result.write(byteBuffer);
            byteBuffer.flip();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void startRead(AsynchronousSocketChannel result) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        AioReadHandler readHandler = new AioReadHandler(result);
        result.read(byteBuffer, byteBuffer, readHandler);
    }

    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {
        exc.printStackTrace();
    }
}
