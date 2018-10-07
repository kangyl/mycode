/**
 * Copyright
 */
package com.kangyl.test.management;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/7
 */
public class HelloAgent {

    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        ObjectName objectName = new ObjectName("myMBean:name=HelloWorld");
        Hello hello = new Hello();
        mBeanServer.registerMBean(hello, objectName);

        ObjectName adapterName = new ObjectName("myMBean:name=htmlAdapter,port=8082");
        HtmlAdaptorServer adaptorServer = new HtmlAdaptorServer();
        adaptorServer.start();
        mBeanServer.registerMBean(adaptorServer, adapterName);

        Kent kent = new Kent();
        mBeanServer.registerMBean(kent, new ObjectName("myMBean:name=kent"));
        kent.addNotificationListener(new HelloListener(), null, hello);


    }
}
