package com.jvm.learn.classLoad;

/**
 *
 * 查询jvm属性路径
 * @Author dabing
 * @Date 2019-06-22 17:29
 **/
public class Learn13 {

    public static void main(String[] args) {
        System.out.println("===" + System.getProperty("sun.boot.class.path"));
        System.out.println("===" + System.getProperty("java.ext.dirs"));
        // 对于maven项目来讲, classpath包含编译后的target/classes目录.
        System.out.println("===" + System.getProperty("java.class.path"));
    }
}
