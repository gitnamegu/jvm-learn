package com.jvm.learn.classLoad;

/**
 *      当java虚拟机初始化一个类型时, 要求他的所有父类都已经被初始化, 但是这条规则不适用与接口.
 *      在这个demo中, 初始化一个类时, 并不一定会先初始化他所实现的接口.
 *      在初始化一个接口时, 也并不一定会先初始化他的父接口.
 * @Author dabing
 * @Date 2019-06-08 12:56
 **/
public class Learn07 {

    public static void main(String[] args) {
        System.out.println(Child07.num2);
    }
}

interface IParent07 {
    Thread thread = new Thread() {
        {
            System.out.println("初始化接口");
        }
    };
}

class Child07 implements IParent07 {
    public static int num2 = 3;
}


