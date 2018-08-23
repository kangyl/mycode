/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.io.nio;

import java.io.IOException;
import java.nio.channels.DatagramChannel;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
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
