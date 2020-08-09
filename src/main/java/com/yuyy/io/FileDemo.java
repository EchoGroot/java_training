package com.yuyy.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Map;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\resouces\\ioFile\\file1.jpg");
        file.createNewFile();
        file = new File("src\\main\\resouces\\ioFile\\");
        for (File fileItem : file.listFiles()) {
            System.out.println(fileItem.getName());
        }
        File[] jpgs = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith("jpg")) {
                    return true;
                }
                return false;
            }
        });
        for (File Item:jpgs) {
            System.out.println(Item.getName());
        }
    }
}
