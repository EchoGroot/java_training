package com.yuyy.io;
import	java.io.FileOutputStream;
import java.io.IOException;
import	java.util.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("user","bob");
        properties.setProperty("age","41");
        PrintWriter printWriter = new PrintWriter("src\\main\\resouces\\ioFile\\test.txt");
        System.out.println(properties);
        properties.list(printWriter);
        printWriter.close();

        FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\resouces\\ioFile\\test.txt",true);
        properties.store(fileOutputStream,"哈哈");
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("src\\main\\resouces\\ioFile\\test.txt");
        Properties properties1 = new Properties();
        properties1.load(fileInputStream);
        System.out.println(properties1);


    }
}
