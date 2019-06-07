package com.jvm.learn.classLoad;

import java.util.UUID;

/**
 *      跟Learn03.java类的区别, 虽然uuid也是final修饰的, 但是uuid在编译器无法确定值是多少, 只有在
 * 运行的时候才能确定. 所以Parent04会被主动访问, 也就会被初始化.
 *
 * @Author dabing
 * @Date 2019-06-07 16:25
 **/
public class Learn04 {

    public static void main(String[] args) {
        System.out.println(Parent04.uuid);
    }
}

class Parent04 {
    public static final String uuid = UUID.randomUUID().toString();

    static {
        System.out.println("parent04 static block");
    }
}
