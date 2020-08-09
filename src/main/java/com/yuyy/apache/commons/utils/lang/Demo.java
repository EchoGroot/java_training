package com.yuyy.apache.commons.utils.lang;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;

import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        testClassUtils();
    }

    private static void testClassUtils(){
        System.out.println(ClassUtils.getShortClassName(Demo.class));
        System.out.println(ClassUtils.getSimpleName(Demo.class));
        System.out.println(ClassUtils.getName(Demo.class));
        System.out.println(ClassUtils.getPackageName(Demo.class));
    }

    // 有时我们需要将两个数组合并为一个数组，用ArrayUtils就非常方便，示例如下：
    private static void testArr() {

        String[] s1 = new String[] { "1", "2", "3" };
        String[] s2 = new String[] { "a", "b", "c" ,"d" ,"e"};
        ArrayUtils.shift(s2,2);

        String[] s = (String[]) ArrayUtils.addAll(s1, s2);

        Stream.of(s).forEach(System.out::println);

        String str = ArrayUtils.toString(s);
        System.out.println(str + ">>" + str.length());

        List<Integer> list=Lists.newArrayList();
        List<Integer> list1=Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.addAll(list);
        list1.stream().forEach(System.out::println);
        System.out.println(list1+">>"+list1.size());
    }
}
