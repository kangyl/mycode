/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/20
 */
public class AioConnectHandler implements CompletionHandler<Void, AsynchronousSocketChannel> {

    private Integer content = 0;

    public AioConnectHandler(Integer content) {
        this.content = content;
    }

    @Override
    public void completed(Void result, AsynchronousSocketChannel socketChannel) {
        socketChannel.write(ByteBuffer.wrap(String.valueOf(content).getBytes()));
//        AsynchronousSocketChannel socket=sockets.get("0");
//        String sendString=jt.getText();
        try{

            ByteBuffer clientBuffer=ByteBuffer.wrap("sdsd".getBytes("UTF-8"));
            socketChannel.write(clientBuffer, clientBuffer, new AioSendHandler(socketChannel));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
        exc.printStackTrace();
    }

    public void startRead(AsynchronousSocketChannel socketChannel) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer, byteBuffer, new AioReadHandler(socketChannel));
    }
}
