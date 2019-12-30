package com.kangyl.test.zerocopy;


import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.nio.channels.FileChannel;

/**
 * 零和拷贝测试
 * @author : kangyl(460720197@qq.com)
 * @date: 2019/12/24
 */
public class ZeroCopyTest {

    public static void main(String[] args) throws Exception{
        File file = new File("/Users/kyl/temp/text.txt");

        Socket socket = new Socket("127.0.0.1",8080);
        try(FileInputStream inputStream = new FileInputStream(file)){
            byte[] datas = new byte[1024];
            int i =0;
            while (( i  = inputStream.read(datas))!=-1){

            }

        }
        FileInputStream inputStream = new FileInputStream(file);

        FileChannel fileChannel = inputStream.getChannel();
//        fileChannel.transferTo();



    }
}
