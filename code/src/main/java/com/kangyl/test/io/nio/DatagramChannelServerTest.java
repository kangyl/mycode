/**
 * Copyright  2018
 */
package com.kangyl.test.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/16
 */
public class DatagramChannelServerTest {

    private Selector selector;
    private DatagramChannel datagramChannel;

    public void init()throws IOException{
        selector = Selector.open();
        datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.socket().bind(new InetSocketAddress(90));
        datagramChannel.register(selector, SelectionKey.OP_READ);
        service();
    }

    @SuppressWarnings("all")
    private void service()throws IOException{
        while (selector.select() > 0) {
            System.out.println("有新channel加入");
            /* 得到已经被捕获了的SelectionKey的集合 */
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = null;
                try {
                    key = (SelectionKey) iterator.next();
                    iterator.remove();

                    if (key.isReadable()) {
                        reveice(key);
                    }
                    if (key.isWritable()) {
                        // send(key);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        if (key != null) {
                            key.cancel();
                            key.channel().close();
                        }
                    } catch (ClosedChannelException cex) {
                        e.printStackTrace();
                    }
                }
            }
            /* 内循环完 */
        }
    }


    synchronized public void reveice(SelectionKey key) throws IOException {
        if (key == null)
            return;
        // ***用channel.receive()获取客户端消息***//
        // ：接收时需要考虑字节长度
        DatagramChannel sc = (DatagramChannel) key.channel();
        String content = "";
        // create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(1024);// java里一个(utf-8)中文3字节,gbk中文占2个字节
        buf.clear();
        SocketAddress address = sc.receive(buf); // read into buffer. 返回客户端的地址信息
        String clientAddress = address.toString().replace("/", "").split(":")[0];
        String clientPost = address.toString().replace("/", "").split(":")[1];

        buf.flip(); // make buffer ready for read
        while (buf.hasRemaining()) {
            buf.get(new byte[buf.limit()]);// read 1 byte at a time
            content += new String(buf.array());
        }
        buf.clear(); // make buffer ready for writing
        System.out.println("接收：" + content.trim());
        // 第一次发；udp采用数据报模式，发送多少次，接收多少次
        ByteBuffer buf2 = ByteBuffer.allocate(65507);
        buf2.clear();
        buf2.put("消息推送内容 abc..UDP是一个非连接的协议，传输数据之前源端和终端不建立连接，当它想传送时就简单地去抓取来自应用程序的数据，并尽可能快地把它扔到网络上。在发送端UDP是一个非连接的协议，传输数据之前源端和终端不建立连接，当它想传送时就简单地去抓取来自应用程序的数据，并尽可能快地把它扔到网络上。在发送端UDP是一个非连接的协议，传输数据之前源端和终端不建立连接，当它想传送时就简单地去抓取来自应用程序的数据，并尽可能快地把它扔到网络上。在发送端@Q"
                .getBytes());
        buf2.flip();
        datagramChannel.send(
                buf2,
                new InetSocketAddress(clientAddress, Integer
                        .parseInt(clientPost))); // 将消息回送给客户端

        // 第二次发
        ByteBuffer buf3 = ByteBuffer.allocate(65507);
        buf3.clear();
        buf3.put("任务完成".getBytes());
        buf3.flip();
        datagramChannel.send(
                buf3,
                new InetSocketAddress(clientAddress, Integer
                        .parseInt(clientPost))); // 将消息回送给客户端
    }

}
