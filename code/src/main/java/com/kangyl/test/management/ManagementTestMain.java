/**
 * Copyright
 */
package com.kangyl.test.management;

//import com.sun.jdmk.comm.HtmlAdaptorServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/6
 */
public class ManagementTestMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(ManagementTestMain.class);
    public static void main(String[] args) {

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        String domainName = "myMBean";
        try{
            ObjectName objectName = new ObjectName(domainName + ":name=HelloWorld");
            mBeanServer.registerMBean(new Hello(), objectName);

            ObjectName adapterName = new ObjectName(domainName + ":name=htmlAdapter,port=8082");
//            HtmlAdaptorServer htmlAdaptorServer = new HtmlAdaptorServer();
//            htmlAdaptorServer.start();

//            mBeanServer.registerMBean(htmlAdaptorServer, adapterName);

            int rmiPort = 1099;
            Registry registry = LocateRegistry.createRegistry(rmiPort);
            JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + rmiPort + "/" + domainName);
            JMXConnectorServer connectorServer = JMXConnectorServerFactory.newJMXConnectorServer(serviceURL, null, mBeanServer);
            connectorServer.start();

        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }

    }


}
