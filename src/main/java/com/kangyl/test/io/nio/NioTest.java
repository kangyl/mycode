/**
 * Copyright  2018
 */
package com.kangyl.test.io.nio;

import java.io.IOException;
import java.nio.channels.DatagramChannel;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/14
 */
public class NioTest {

    public static void main(String[] args) {
        try{
//            ServerSocketChannelTest channelTest = new ServerSocketChannelTest();
//            channelTest.init();

            DatagramChannelServerTest datagramChannelServerTest = new DatagramChannelServerTest();
            datagramChannelServerTest.init();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
