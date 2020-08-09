package com.yuyy.io;

import org.checkerframework.checker.units.qual.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.String;



public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src\\main\\resouces\\ioFile\\test.txt");
        int count=0;
        byte[] bytes = new byte[3];
        while((count= fileInputStream.read(bytes))!= -1){
            System.out.print(new String(bytes,0, count));
        }
    }
}
