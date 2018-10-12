package com.kangyl.test.seriable;

import java.io.*;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年09月30日
 */
public class TestMain {

    public static void main(String[] args) {
        serialClass();
        deserialClass();
    }

    private static void deserialClass() {

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\Person.txt"));
            SerialObj person = (SerialObj ) inputStream.readObject();
            System.out.println(person.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serialClass() {
        SerialObj person = new SerialObj();
        person.setName("sdds");
        person.setAddr("dsd");

        try {
            OutputStream stream = new FileOutputStream("D:\\Person.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
            objectOutputStream.writeObject(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
