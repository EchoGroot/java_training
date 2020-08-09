package com.yuyy.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutStreamDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\resouces\\ioFile\\test.txt",true);
        String str = "\r\nsadkl快乐了看看了\r\ndsfdsas放到";
        fileOutputStream.write(str.getBytes());
        fileOutputStream.flush();
        Thread.sleep(2000);
        fileOutputStream.write(str.getBytes());
    }
}
