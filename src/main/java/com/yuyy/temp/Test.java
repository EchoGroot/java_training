package com.yuyy.temp;



import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.*;
import java.util.stream.Stream;

/**
 * @author yuyy
 * @date 2019/9/25 10:56
 */
public class Test {
    // 有时我们需要将两个数组合并为一个数组，用ArrayUtils就非常方便，示例如下：
    private static void testArr() {
        String[] s1 = new String[] { "1", "2", "3" };
        String[] s2 = new String[] { "a", "b", "c" };

        String[] s = (String[]) ArrayUtils.addAll(s1, s2);

        Stream.of(s).forEach(System.out::println);

        String str = ArrayUtils.toString(s);
        System.out.println(str + ">>" + str.length());


    }
    public static void main(String[] arg) throws IOException {
        testArr();
        //读取txt文件
        /*FileReader file=new FileReader("C:\\Users\\Yuyy\\Desktop\\Ego.txt");
        BufferedReader bufferedReader=new BufferedReader(file);
        String line="";
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }*/
        //写入txt文件
        /*File file1 = new File("C:\\Users\\Yuyy\\Desktop\\out.txt");
        file1.createNewFile();
        FileWriter fileWriter=new FileWriter(file1);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write("4545sssafaf");
        bufferedWriter.flush();
        bufferedWriter.close();*/
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

    @org.junit.Test
    public void apacheCommons(){
        System.out.println(RandomStringUtils.randomAscii(5));
        System.out.println(RandomStringUtils.randomNumeric(5));
        System.out.println(RandomStringUtils.randomPrint(5));
        System.out.println(RandomUtils.nextInt());
    }


}
