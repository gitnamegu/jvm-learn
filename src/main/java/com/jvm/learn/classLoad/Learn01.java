package com.jvm.learn.classLoad;

/**
 *      对于静态字段来说, 访问此静态字段时, 只有直接定义了此字段的类才会被初始化. 这个demo里, 虽然是子类来调用,
 * 但其实是对父类的主动访问, 所以只会初始化父类. 初始化类时, 调用方并不一定是主动访问方.
 * @Author dabing
 * @Date 2019-06-07 12:43
 **/
public class Learn01 {

    public static void main(String[] args) {
        System.out.println(Child.id);
    }

}



class Parent {
    public static int id = 0;
    static {
        System.out.println("parent static block");
    }

}

class Child extends Parent {
    static {
        System.out.println("child static block");
    }
}