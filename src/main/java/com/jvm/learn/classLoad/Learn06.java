package com.jvm.learn.classLoad;

/**
 *      这个程序中, 访问了Parent06类的静态方法, 所以Parent06类会被初始化. 初始化的时候, 顺序是从
 * 上往下的, 所以num1的值是1, num2的值是0.
 *      同样, 这个demo也可以展示类的准备阶段的重要性. 在准备阶段, 会为静态变量赋默认值. 准备阶段完成
 * 后, 这个类的静态变量就拥有了默认值. 不然, 当程序运行时, Parent06类被初始化, 执行代码时, num2还
 * 没有默认值, 也就无法被++操作.
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
