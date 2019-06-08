package com.jvm.learn.classLoad;

import java.util.UUID;

/**
 *      对于接口来讲, 在这个demo中, 变量在编译期无法确定, 在运行的时候主动访问接口, 会初始化
 * 接口. 如果demo中的uuid在编译期是一个确定的值, 则IParent06不会被初始化. 因为在编译期会将
 * uuid编译进Learn05类的常量池中.
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