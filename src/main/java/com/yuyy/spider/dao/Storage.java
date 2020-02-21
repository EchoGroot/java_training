package com.yuyy.spider.dao;

import java.io.*;

/**
 * @author yuyy
 * @date 2019/8/21 15:10
 */
public class Storage {
    public static void method(String file, String conent) {
        BufferedWriter out = null;
        try{
            out=new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file,true)
                    )
            );
            out.write(conent+"\r\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
