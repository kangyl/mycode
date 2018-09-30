package com.kangyl.test.seriable;

import com.kangyl.test.hash.Person;

import java.io.*;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (yulin.kang@ucarinc.com)
 * @since 2018年09月30日
 */
public class TestMain {

    public static void main(String[] args) {
//        serialClass();
//        deserialClass();
    }

    private static void deserialClass() {

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\Person.txt"))){

            Person person = (Person) inputStream.readObject();
            System.out.println(person.getName());
        }catch (Exception  e){

        }
    }

    private static void serialClass() {
        Person person = new Person();
        person.setName("sdds");
        person.setId("dsd");

        try(OutputStream stream = new FileOutputStream("D:\\Person.txt")){

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
            objectOutputStream.writeObject(person);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
