package com.jvm.learn.classLoad;

/**
 * 主动使用一个子类时, 会初始化子类, 初始化子类前父类会先被初始化.
 * @Author dabing
 * @Date 2019-06-07 13:32
 **/
public class Learn02 {

    public static void main(String[] args) {
        System.out.println(Child02.id);
    }
}

class Parent02 {
    static {
        System.out.println("parent static block");
    }
}

class Child02 extends Parent02 {
    public static int id;
    static {
        System.out.println("child static block");
    }
}
