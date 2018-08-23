/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.io.nio;

import java.io.IOException;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
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
