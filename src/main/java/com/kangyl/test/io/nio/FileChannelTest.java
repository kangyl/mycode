/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/8/13
 */
public class FileChannelTest {

    public static void main(String[] args) {
//        try (RandomAccessFile rw = new RandomAccessFile("E:\\kp.log", "rw")) {
//            FileChannel channel = rw.getChannel();
//            ByteBuffer buf = ByteBuffer.allocate(48);
//
//            int size;
//            while ((size = channel.read(buf)) != -1) {
//                System.out.println("read:" + size);
//
//                buf.flip();
//                while (buf.hasRemaining()) {
//                    System.out.println((char) buf.get());
//                }
//
//                buf.clear();
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        testTranfer();
        ioTransfer();
    }


    public static void testTranfer() {
        long begin = System.currentTimeMillis();
        try(RandomAccessFile readFile = new RandomAccessFile("E:\\kp.log", "rw");
            RandomAccessFile toFile = new RandomAccessFile("E:\\kp2.log", "rw")){
            FileChannel rw = readFile.getChannel();
            FileChannel fileChannel = toFile.getChannel();
            long size = rw.size();
            fileChannel.transferFrom(rw, 0, size);
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时:" + (end - begin));
    }

    public static void ioTransfer() {
        long begin = System.currentTimeMillis();
        try(InputStream fileInputStream = new BufferedInputStream(new FileInputStream("E:\\kp.log"));
            OutputStream os = new BufferedOutputStream(new FileOutputStream("E:\\kp2.log"))) {
            byte[] data = new byte[1024];
            int size ;
            while ((size = fileInputStream.read(data)) != -1) {
                os.write(data, 0, size);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时:" + (end - begin));
    }
}
