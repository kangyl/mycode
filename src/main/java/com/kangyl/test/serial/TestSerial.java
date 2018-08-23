/**
 * Copyright 厦门四方中信信息科技有限公司 版权所有 违者必究 2018
 */
package com.kangyl.test.serial;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : kangyl(kangyl@mysinosoft.com)
 * @date: 2018/3/10
 */
public class TestSerial {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
//        User tom = new User().setId(UUID.randomUUID().toString()).setUserCode("1").setUserName("tom");
//        File file = new File("D:\\360CloudUI\\aa.txt");
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
//            oos.writeObject(tom);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        try(FileInputStream fis = new FileInputStream(file);ObjectInputStream ois = new ObjectInputStream(fis)){
//            User user = (User) ois.readObject();
//            System.out.println(user);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        try(TestAutoClose autoClose = new TestAutoClose()){
//            System.out.println(" execute method");
//
//        }catch (Exception e){
//
//        }

//        HashMap<String, String> map = new HashMap<>();
//        for(int i = 0;i<20;i++) {
//            map.put(String.valueOf(i), String.valueOf(i));
//        }
//
//        System.out.println(map.get("11"));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                try {
                    lock.lock();
                    System.out.println(name + "开始休眠");
                    Thread.sleep(10 * 1000);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(name + "未释放锁");
//                    lock.unlock();
                }
            }
        });

        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                try {
                    lock.lock();
                    System.out.println("当前线程名称为:" + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(name + "释放锁");
                    lock.unlock();
                }
            }
        });

        thread2.start();

    }


}
