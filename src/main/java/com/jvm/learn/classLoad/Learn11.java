package com.jvm.learn.classLoad;

import java.io.*;

/**
 *      类加载器在加载类时, 如果发现已经加载过, 则不会再次加载, 而是直接返回类的Class对象. 也就是说同一个类
 * 加载器及其所有的父类加载器, 不会加载两个相同的类. 也就是说在一个类加载器的命名空间中, 不会出现两个完整名字
 * 相同的类(包括包名). 但是在这个demo中, 创建了两个类加载器, 所以class字节码会被加载两遍.
 * @Author dabing
 * @Date 2019-06-18 22:26
 **/
public class Learn11 extends ClassLoader {

    private String mineClassLoaderName;

    public Learn11(String mineClassLoaderName) {
        this.mineClassLoaderName = mineClassLoaderName;
    }

    public Learn11(ClassLoader parent, String mineClassLoaderName) {
        super(parent);
        this.mineClassLoaderName = mineClassLoaderName;
    }

    @Override
    protected Class<?> findClass(String classPath) {
        File file = new File(classPath);
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        byte[] datas = null;
        try {
            is = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            int length = is.read();
            while (length != -1) {
                baos.write(length);
                length = is.read();
            }
            datas = baos.toByteArray();
            System.out.println("自定义类加载器");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (datas == null) {
            return null;
        }
        return this.defineClass(null, datas, 0, datas.length);
    }

    /**
     *      创建了两个类加载器, 所以会加载两遍字节码.
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        String mineClassLoaderName1 = "mineClassLoaderName";
        Learn11 learn11_1 = new Learn11(mineClassLoaderName1);
        String classPath = "/Users/dabing/jvm/Learn02.class";
        Class<?> clazz1 = learn11_1.loadClass(classPath);
        System.out.println("class:" + clazz1.hashCode());


        String mineClassLoaderName2 = "mineClassLoaderName2";
        Learn11 learn11_2 = new Learn11(mineClassLoaderName2);
        Class<?> clazz2 = learn11_2.loadClass(classPath);
        System.out.println("class:" + clazz2.hashCode());

    }
}
