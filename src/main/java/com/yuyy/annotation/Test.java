package com.yuyy.annotation;
import	java.lang.instrument.ClassFileTransformer;
import	java.time.Clock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * description: 测试类 <br>
 * version: 1.0 <br>
 * date: 2020/7/12 15:50 <br>
 * author: objcat <br>
 */
@MyAnno1(name="张三",age=22)
@MyAnno3(methodName = "method1",className = "com.yuyy.annotation.Test")
public class Test {

    /**
     * description: 有注解的方法 <br>
     * version: 1.0 <br>
     * date: 2020/7/12 15:51 <br>
     * author: objcat <br>
     *
     * @param param1
     * @param param2
     * @return void
     */
    @MyAnno1(name="张三",age=22)
    public static void method1(int param1,int param2){
        System.out.println(param1+param2);
    }

    @MyAnno2(2)
    public void method2() {
        method1(1, 2);
    }

    @org.junit.jupiter.api.Test
    public void testReflect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<Test> testClass = Test.class;
        MyAnno3 myAnno3 = testClass.getAnnotation(MyAnno3.class);
        Class<?> clazz = Class.forName(myAnno3.className());
        Method method = clazz.getMethod(myAnno3.methodName(),int.class,int.class);
        method.invoke(clazz.newInstance(), 2,4);
    }
}
