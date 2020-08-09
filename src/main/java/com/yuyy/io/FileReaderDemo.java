package com.yuyy.io;
import	java.io.FileOutputStream;
import	java.io.FileInputStream;

import java.io.*;

public class FileReaderDemo {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src\\main\\resouces\\ioFile\\test_chinese.txt");
        int count = 0;
        char[] ch=new char[2];
        while ((count=fileReader.read(ch))!= -1){
            System.out.println(new String(ch,0,count));
        }
        fileReader.close();
        FileWriter fileWriter = new FileWriter("src\\main\\resouces\\ioFile\\test_chinese.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "sda快了快了快乐看了看看来";
        bufferedWriter.write(str);
        bufferedWriter.close();

        FileInputStream in = new FileInputStream("src\\main\\resouces\\ioFile\\test_chinese.txt");
        InputStreamReader utf8 = new InputStreamReader(in, "utf8");
        count =0 ;

        while((count = utf8.read(ch))!=-1){

            System.out.println(ch);
        }
        FileOutputStream fos = new FileOutputStream("src\\main\\resouces\\ioFile\\test_chinese.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, "utf8");
        outputStreamWriter.write("d大幅度随风倒");
        outputStreamWriter.close();
    }
}
