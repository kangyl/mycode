/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/8/14
 */
public class ServerSocketChannelTest {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private Charset charSet = Charset.forName("UTF-8");
    private final int port = 8080;

    private String decode(ByteBuffer byteBuffer) {
        return charSet.decode(byteBuffer).toString();
    }

    @SuppressWarnings("all")
    public void init() throws IOException {

        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.socket().setReuseAddress(true);
        service();
    }

    @SuppressWarnings("all")
    private void service() throws IOException{
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select()>0) {

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = null;
                try{
                    selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        handleAccept(selectionKey);
                    }
                    if (selectionKey.isReadable()) {
                        handleRead(selectionKey);
                    }
                    if (selectionKey.isWritable()) {
                        System.out.println("isWriteable");
                    }
                    iterator.remove();

                }catch (IOException e){
                    e.printStackTrace();
                    if (selectionKey != null) {
                        selectionKey.cancel();
                        selectionKey.channel().close();
                    }
                }
            }
        }
    }

    private void handleRead(SelectionKey selectionKey)throws IOException {

        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        socketChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(60);
        byteBuffer.clear();

        StringBuilder sb = new StringBuilder();

        //数据结束可能-1和0
        while (socketChannel.read(byteBuffer) >0) {
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                sb.append(decode(byteBuffer));
            }
            byteBuffer.clear();
        }
        System.out.println("接受:"+sb.toString());
        socketChannel.write(ByteBuffer.wrap("服务端已经接收到你的请求了。".getBytes()));
    }

    private void handleAccept(SelectionKey selectionKey) throws IOException{
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();

        System.out.println("接收到客户端的请求,客户端地址为:" + socketChannel.getRemoteAddress() +
                "端口号:" + socketChannel.getLocalAddress());

        socketChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.register(selector, SelectionKey.OP_READ, byteBuffer);
    }

    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date());
        return time;
    }
}
