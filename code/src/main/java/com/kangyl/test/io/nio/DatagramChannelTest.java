/**
 * Copyright  2018
 */
package com.kangyl.test.io.nio;

import com.kangyl.test.util.CharSetUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/16
 */
public class DatagramChannelTest {

    private Selector selector;
    private DatagramChannel datagramChannel;

    @SuppressWarnings("all")
    public void init()throws IOException{
        selector = Selector.open();
        datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.socket().connect(new InetSocketAddress("127.0.0.1",90));

        datagramChannel.register(selector, SelectionKey.OP_READ);
        service();
    }

    @SuppressWarnings("all")
    private void service()throws IOException{

        datagramChannel.write(ByteBuffer.wrap("这条消息来自客户端".getBytes()));
        datagramChannel.register(selector, SelectionKey.OP_READ);
        while (selector.select() > 1) {
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                DatagramChannel channel = (DatagramChannel)key.channel();
                if (key.isReadable()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    ByteBuffer buffer = ByteBuffer.allocate(100);
                    while (channel.read(buffer) > 0) {
                        buffer.flip();

                        while (buffer.hasRemaining()) {
                            stringBuilder.append(CharSetUtil.decode(buffer));
                        }
                        buffer.clear();
                    }

                    System.out.println("收到服务端的消息为:"+stringBuilder);
                }
            }
        }
    }
}
