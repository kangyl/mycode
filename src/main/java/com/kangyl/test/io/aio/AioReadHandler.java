/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/19
 */
public class AioReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socketChannel;
    private CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
    private String msg;

    public AioReadHandler(AsynchronousSocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {

        if (result > 0) {
            buffer.flip();
            try {
                msg = decoder.decode(buffer).toString();
                buffer.compact();
            } catch (CharacterCodingException e) {
                e.printStackTrace();
            }

            socketChannel.read(buffer, buffer, this);
            try {
                write(socketChannel);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else if (result == -1) {
            try {
                System.out.println("客户端断线:" + socketChannel.getRemoteAddress().toString());
                buffer = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void write(AsynchronousSocketChannel socketChannel) throws UnsupportedEncodingException {
        String sendString="服务器回应,你输出的是:"+msg;
        ByteBuffer clientBuffer=ByteBuffer.wrap(sendString.getBytes("UTF-8"));
        socketChannel.write(clientBuffer, clientBuffer, new AioWriteHandler(socketChannel));
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        exc.printStackTrace();
    }
}
