package com.yuyy.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src\\main\\resouces\\ioFile\\test.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int count=0;
        while((count= bufferedInputStream.read())!= -1){
            System.out.print( (char)count);
        }
    }
}
