package com.jvm.learn.classLoad;

/**
 *      这个程序中, 访问了Parent06类的静态方法, 所以Parent06类会被初始化. 初始化的时候, 顺序是从
 * 上往下的, 所以num1的值是1, num2的值是0.
 * @Author dabing
 * @Date 2019-06-07 17:04
 **/
public class Learn06 {

    public static void main(String[] args) {
        Parent06 parent06 = Parent06.getInstance();
        System.out.println(Parent06.num1);
        System.out.println(Parent06.num2);
    }


}

class Parent06 {
    public static int num1;
    public static Parent06 parent06 = new Parent06();

    public Parent06() {
       num1++;
       num2++;
    }

    public static int num2 = 0;

    public static Parent06 getInstance() {
        return parent06;
    }
}
