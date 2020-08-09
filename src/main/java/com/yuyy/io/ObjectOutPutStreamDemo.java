package com.yuyy.io;
import com.yuyy.io.pojo.Person;

import java.io.*;

public class ObjectOutPutStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream out = new FileOutputStream("src\\main\\resouces\\ioFile\\test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        Person person = new Person("qweq",55,"sad");
        objectOutputStream.writeObject(person);
        objectOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("src\\main\\resouces\\ioFile\\test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person object = (Person) objectInputStream.readObject();
        System.out.println(object);
    }
}
