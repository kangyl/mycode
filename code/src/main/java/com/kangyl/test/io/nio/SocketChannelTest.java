/**
 * Copyright  2018
 */
package com.kangyl.test.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/14
 */
public class SocketChannelTest {

    private Selector selector;
    private SocketChannel socketChannel;
    private Charset charSet = Charset.forName("UTF-8");
    private final int port = 8080;

    private String decode(ByteBuffer byteBuffer) {
        return charSet.decode(byteBuffer).toString();
    }

    @SuppressWarnings("all")
    public void init() throws IOException{

        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", port));

        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        service();
    }

    @SuppressWarnings("all")
    private void service() throws IOException {
        while (true) {
            int select = selector.select();
            if (select == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isConnectable()) {
                    handleConnect(key);

                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(100);
                    StringBuilder sb = new StringBuilder();
                    while (channel.read(byteBuffer) >0) {
                        byteBuffer.flip();

                        while (byteBuffer.hasRemaining()) {
                            sb.append(decode(byteBuffer));
                        }
                    }
                    System.out.println("服务端发来的消息为:"+sb);
                }
                iterator.remove();
            }
        }

    }

    private void handleConnect(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        //判断是否正在连接
        if (channel.isConnectionPending()) {
            //阻塞直至完成连接操作
            channel.finishConnect();
        }

        //连接完成后设置为非阻塞操作
        channel.configureBlocking(false);

        channel.write(ByteBuffer.wrap("这条消息来自kent客户端".getBytes()));
        channel.register(selector, SelectionKey.OP_READ);
    }
}
