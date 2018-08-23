/**
 * Copyright  2018
 */
package com.kangyl.test.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/22
 */
public class SimpleReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private Charset charSet = Charset.forName("UTF-8");

    private String decode(ByteBuffer byteBuffer) {
        return charSet.decode(byteBuffer).toString();
    }


    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        if (result > 0) {
            attachment.flip();
            System.out.println(decode(attachment));
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        exc.printStackTrace();
    }
}
