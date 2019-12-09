/**
 * Copyright
 */
package com.kangyl.test.management;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Iterator;
import java.util.Set;

/**
 *本地连接远程MBean
 *@author : kangyl(460720197@qq.com)
 *@date: 2018/10/7
 */
public class Client {

    @SuppressWarnings("all")
    public static void main(String[] args)throws Exception {
        String domainName = "myMBean";
        int rmiPort = 1099;
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + rmiPort + "/" + domainName);
        JMXConnector connector = JMXConnectorFactory.connect(jmxServiceURL);
        MBeanServerConnection mbs = connector.getMBeanServerConnection();

        String[] domains = mbs.getDomains();
        System.out.println("Domains:----------------");
        int j = 0;
        for (String domain : domains) {
            System.out.println("domain:" +j + domain);
            j++;
        }

        System.out.println("total domain is " + mbs.getMBeanCount());
        ObjectName objectName = new ObjectName(domainName + ":name=HelloWorld");
        mbs.setAttribute(objectName, new Attribute("Name", "kent"));
        System.out.println("NAME:" + mbs.getAttribute(objectName, "Name"));

        //proxy
        HelloMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbs, objectName, HelloMBean.class, false);
        proxy.printHello();
        proxy.printHelloTo(" kent2");

        //rmi
        mbs.invoke(objectName, "printHello", null, null);
        mbs.invoke(objectName, "printHelloTo", new String[]{" haa"}, new String[]{String.class.getName()});

        MBeanInfo info = mbs.getMBeanInfo(objectName);
        System.out.println("Hello Class: "+info.getClassName());
        for(int i=0;i<info.getAttributes().length;i++){
            System.out.println("Hello Attribute:"+info.getAttributes()[i].getName());
        }
        for(int i=0;i<info.getOperations().length;i++){
            System.out.println("Hello Operation:"+info.getOperations()[i].getName());
        }

        //ObjectName of MBean
        System.out.println("all ObjectName:--------------");
        Set<ObjectInstance> set = mbs.queryMBeans(null, null);
        for(Iterator<ObjectInstance> it = set.iterator(); it.hasNext();){
            ObjectInstance oi = it.next();
            System.out.println("\t"+oi.getObjectName());
        }
        connector.close();
    }
}
