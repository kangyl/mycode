/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/22
 */
public class SimpleAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {

    private Charset charSet = Charset.forName("UTF-8");

    private String decode(ByteBuffer byteBuffer) {
        return charSet.decode(byteBuffer).toString();
    }


    @Override
    public void completed(AsynchronousSocketChannel ch, AsynchronousServerSocketChannel attachment) {

        System.out.println("AioAcceptHandler.completed called");
        attachment.accept(attachment, this);
        try{
            System.out.println("有客户端连接:" +ch.getRemoteAddress().toString());
        }catch (IOException e){
            e.printStackTrace();
        }

        startRead(ch);
//        try{
//            StringBuilder builder = new StringBuilder();
//            while(true){
//                Future<Integer> read = ch.read(byteBuffer);
//
//                Integer i = read.get();
//                if(i<=0){
//                    break;
//                }
//                byteBuffer.flip();
//
//
//                while (byteBuffer.hasRemaining()) {
//                    builder.append(decode(byteBuffer).toString());
//                }
//            }
//            System.out.println(builder);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    private void startRead(AsynchronousSocketChannel socketChannel) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SimpleReadHandler handler = new SimpleReadHandler();
        socketChannel.read(byteBuffer, byteBuffer, handler);
    }

    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {

    }
}
