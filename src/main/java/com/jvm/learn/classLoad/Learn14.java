package com.jvm.learn.classLoad;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 *      类加载器的的命名空间.
 *      同一个命名空间的类是相互可见的.
 *      子类加载器的命名空间包含所有父加载器的命名空间. 因此自加载器加载的类能看见父加载器加载的类, 但是父
 * 加载器加载的类不能看见子类加载器加载的类.
 *      如果两个类加载器之间没有直接或间接的父子关系, 那么他们加载的类相互不可见.
 *      这个demo中, 使用两个类加载器对象来加载同一个字节码文件, 这两个类加载器没有父子关系, 相互独立, 所以
 * 他们互相加载的类之间不可见, 使用类创建出来的对象也相互不可见.
 *
 * @Author dabing
 * @Date 2019-06-22 23:02
 **/
public class Learn14 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Learn12 loader1 = new Learn12("loader1");
        Learn12 loader2 = new Learn12("loader2");

        Class<?> clazz1 = loader1.loadClass("/Users/dabing/jvm/Learn14DemoObj.class");
        Class<?> clazz2 = loader2.loadClass("/Users/dabing/jvm/Learn14DemoObj.class");

        System.out.println(clazz1 == clazz2);

        Object obj1 = clazz1.newInstance();
        Object obj2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setLearn14DemoObj", Object.class);
        method.invoke(obj1, obj2);
    }

}
