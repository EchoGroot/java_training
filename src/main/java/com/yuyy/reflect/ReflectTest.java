package com.yuyy.reflect;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author yuyy
 * @date 2020/5/5 22:27
 */
public class ReflectTest {

    /**
     * 获取Class对象
     * @throws ClassNotFoundException
     */
    @Test
    public void getClass1() throws ClassNotFoundException {
        //方式一：Class.forName("全类名");
        //Source源代码阶段
        Class class1 = Class.forName("com.yuyy.reflect.Person");
        System.out.println("class1 = " + class1);

        //方式二：类名.class
        //Class类对象阶段
        Class class2 = Person.class;
        System.out.println("class2 = " + class2);

        //方式三：对象.getClass();
        //Runtime运行时阶段
        Person person = new Person();
        Class class3 = person.getClass();
        System.out.println("class3 = " + class3);

        //比较三个对象
        System.out.println(class1 == class2);    //true
        System.out.println(class1 == class3);    //true
    }

    /**
     * 获取成员变量
     */
    @Test
    public void getAndSetField() throws NoSuchFieldException, IllegalAccessException {
        Class personClass = Person.class;
        Person person = new Person();
        person.setA("aa");
        person.setB("bb");
        person.setC("cc");
        person.setD("dd");
        Field[] personClassFields = personClass.getFields();
        Field field = personClass.getField("a");
        System.out.println("获取指定名称为a的成员变量："+field);
        Object obj = field.get(person);
        System.out.println("获取该对象的某个成员变量："+obj);
        field.set(person,"aaa");
        obj = field.get(person);
        System.out.println("修改该对象的某个成员变量："+obj);
        System.out.println("获取所有public修饰的成员变量");
        Arrays.stream(personClassFields).forEach( System.out::println);
    }

    /**
     * 获取成员变量,忽略访问修饰符
     */
    @Test
    public void getAndSetDeclareField() throws NoSuchFieldException, IllegalAccessException {
        Class personClass = Person.class;
        Person person = new Person();
        person.setA("aa");
        person.setB("bb");
        person.setC("cc");
        person.setD("dd");
        Field declaredField = personClass.getDeclaredField("c");
        System.out.println("获取指定名称为c的成员变量："+declaredField);
        declaredField.setAccessible(true);
        Object obj=declaredField.get(person);
        System.out.println("获取该对象的某个成员变量："+obj);
        declaredField.set(person,"ccc");
        obj = declaredField.get(person);
        System.out.println("修改该对象的某个成员变量："+obj);
        System.out.println("获取所有的成员变量，不考虑修饰符");
        Field[] declaredFields = personClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach( System.out::println);
    }

    /**
     * 获取构造器
     */
    @Test
    public void getConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;
        Constructor[] personClassConstructors = personClass.getConstructors();
        Arrays.stream(personClassConstructors).forEach(System.out::println);

        Constructor constructor = personClass.getConstructor();
        System.out.println("获取无参构造函数："+constructor);
        Object obj = constructor.newInstance();
        System.out.println("通过构造函数实例化的对象："+obj);

        constructor = personClass.getConstructor(String.class,Integer.class);
        System.out.println("获取有参构造函数："+constructor);
        obj = constructor.newInstance("zhangsan", 22);
        System.out.println("通过构造函数实例化的对象："+obj);

        //对于一般的无参构造函数，我们都不会先获取无参构造器之后在进行初始化,而是直接调用Class类内的newInstance()方法
        Object person3 = personClass.newInstance();
        System.out.println("person3 = " + person3);
    }

    /**
     * 获取方法
     */
    @Test
    public void getMethod() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class personClass = Person.class;
        Object obj = personClass.newInstance();
        Method[] methods = personClass.getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        Method method = personClass.getMethod("eat");
        method.invoke(obj);

        method = personClass.getMethod("eat",String.class);
        method.invoke(obj,"balala");
    }

    /**
     * 跟句配置文件实例对应的对象
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Test
    public void getProperties() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.加载配置文件
        //1.1创建Properties对象
        Properties pro = new Properties();
        //1.2加载配置文件
        //1.2.1获取class目录下的配置文件(使用类加载器)
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("pro.properties");
        pro.load(inputStream);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);
    }


}
