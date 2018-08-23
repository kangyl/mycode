/**
 * Copyright  2018
 */
package com.kangyl.test.io.nio;

import java.io.IOException;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/8/14
 */
public class NioClientTest {

    public static void main(String[] args) {

        try {
//            SocketChannelTest channelTest = new SocketChannelTest();
//            channelTest.init();

            DatagramChannelTest datagramChannelTest = new DatagramChannelTest();
            datagramChannelTest.init();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
