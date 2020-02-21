package com.yuyy.temp;

import java.io.*;
import java.util.concurrent.*;

/**
 * @author yuyy
 * @date 2019/9/25 10:56
 */
public class Test {
    public static void main(String[] arg) throws IOException {
        //读取txt文件
        /*FileReader file=new FileReader("C:\\Users\\Yuyy\\Desktop\\Ego.txt");
        BufferedReader bufferedReader=new BufferedReader(file);
        String line="";
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }*/
        //写入txt文件
        File file1 = new File("C:\\Users\\Yuyy\\Desktop\\out.txt");
        file1.createNewFile();
        FileWriter fileWriter=new FileWriter(file1);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write("4545sssafaf");
        bufferedWriter.flush();
        bufferedWriter.close();
        /*for(int i=0;i<10;i++){
            Callable<Integer> callable=new CallableImpl();
            FutureTask<Integer> future=new FutureTask<>(callable);
            new Thread(future,"name"+i).start();
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/
        //线程池
        /*ExecutorService pool=Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Callable<Integer> callable=new CallableImpl();
            FutureTask<Integer> futureTask=new FutureTask<>(callable);
            pool.submit(futureTask);
        }
        pool.shutdown();*/


    }


}
