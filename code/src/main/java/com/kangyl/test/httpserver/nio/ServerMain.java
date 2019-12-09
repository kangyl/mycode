package com.kangyl.test.httpserver.nio;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;


/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/11/27
 */
public class ServerMain {


    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final String INDEX_PAGE = "index.html";
    private static final String STATIC_RESOURCE_DIR = "static";
    private static final String META_RESOURCE_DIR_PREFIX = "/meta/";
    private static final String KEY_VALUE_SEPARATOR = ":";
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        try {
            start(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start(int port) throws IOException {


        Selector selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);
        server.bind(new InetSocketAddress("127.0.0.1", port));

        while (true) {
            int readNum = selector.selectNow();
            if (readNum == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();

                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    request(selectionKey);
                    selectionKey.interestOps(SelectionKey.OP_WRITE);
                } else if (selectionKey.isWritable()) {
                    response(selectionKey);
                }
            }
        }
    }

    private static void request(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(DEFAULT_BUFFER_SIZE);

        boolean hasContent = false;
        while (channel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            CharBuffer decode = Charset.forName("UTF-8").decode(byteBuffer);
            String cont = decode.toString();
            String[] split = cont.split(CRLF);
            System.out.println(split);
            System.out.println(cont);
            byteBuffer.clear();
            hasContent = true;
        }

        if (hasContent) {
            selectionKey.interestOps(SelectionKey.OP_WRITE);
        } else {
            channel.close();
        }
        System.out.println("read out");

    }

    private static void response(SelectionKey selectionKey) throws IOException {
        System.out.println("response start");
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        String responseText = getResponseText();
        ByteBuffer byteBuffer = ByteBuffer.wrap(responseText.getBytes());
        while (byteBuffer.hasRemaining()) {
            channel.write(byteBuffer);
        }
        channel.close();
        System.out.println("response out");

    }

    private static String getResponseText() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n");
        sb.append("Content-Type: text/html; charset=UTF-8\n");
        sb.append("\n");
        sb.append("<html>");
        sb.append("  <head>");
        sb.append("    <title>");
        sb.append("      NIO Http Server");
        sb.append("    </title>");
        sb.append("  </head>");
        sb.append("  <body>");
        sb.append("    <h1>Hello World!</h1>");
        sb.append("  </body>");
        sb.append("</html>");
        return sb.toString();
    }
}
