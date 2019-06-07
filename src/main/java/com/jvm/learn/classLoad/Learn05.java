package com.jvm.learn.classLoad;

import java.util.UUID;

/**
 *      对于接口来讲, 在这个demo中, 变量在编译期无法确定, 在运行的时候主动访问接口, 会初始化
 * 接口. 如果在运行时初始化了接口, 那么父接口也会被初始化. 如果接口的常量在编译期可以确定, 那么
 * 程序在运行的时候不会再去初始化接口, 父接口也不会被初始化.
 * @Author dabing
 * @Date 2019-06-07 16:46
 **/
public class Learn05 {

    public static void main(String[] args) {
        System.out.println(IParent06.uuid);
    }


}


interface IParent05 {
    int id = 1;
}

interface IParent06 extends IParent05 {
    String uuid = UUID.randomUUID().toString();
}