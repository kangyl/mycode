/**
 * Copyright
 */
package com.kangyl.test.management;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/7
 */
public class Kent extends NotificationBroadcasterSupport implements KentMBean {

    private int seq = 0;

    @Override
    public void hi() {
        Notification notification = new Notification("yulin.kang", this, ++seq,
                System.currentTimeMillis(), "kent");
        sendNotification(notification);

    }
}
