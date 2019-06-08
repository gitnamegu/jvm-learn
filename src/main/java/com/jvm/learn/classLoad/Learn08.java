package com.jvm.learn.classLoad;

/**
 * 获取加载此类的加载器, 如果此类是由根类加载器加载的, 有可能返回null.
 * @Author dabing
 * @Date 2019-06-08 13:59
 **/
public class Learn08 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz1 = Class.forName("com.jvm.learn.classLoad.Parent08");
        System.out.println(clazz1.getClassLoader());
    }
}


class Parent08 {

}
