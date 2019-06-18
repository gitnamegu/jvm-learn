package com.jvm.learn.classLoad;

import java.io.*;

/**
 *      自定义类加载器, 但是自定义类加载器不会去加载, 而是父亲委托, 由于根类加载器/扩展类加载器无法加载
 * classpath下的字节码文件, 而应用类加载器可以加载. 这个demo中要被加载的字节码在项目的classpath下,
 * 所以最终由系统类加载器来加载.
 * @Author dabing
 * @Date 2019-06-08 16:22
 **/
public class Learn09 extends ClassLoader {

    private String classLoaderName;
    private static final String fileExtension = ".class";

    public Learn09(String classLoaderName) {
        super(); // 构建一个类加载器并将应用类加载器作为自定义类加载器的父亲
        this.classLoaderName = classLoaderName;
    }

    public Learn09(ClassLoader parent, String classLoaderName) {
        super(parent); // 显式的指定父亲
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "Learn09{" +
                "classLoaderName='" + classLoaderName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }


    /**
     * 返回类的Class对象
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            //this.classLoaderName = classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(className + fileExtension));

            baos = new ByteArrayOutputStream();
            int length = is.read();
            while (length != -1) {
                baos.write(length);
                length = is.read();
            }
            data = baos.toByteArray();
        } catch (Exception e) {
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
        System.out.println("======");
        if (data == null) {
            return null;
        }
        return this.defineClass(className, data, 0, data.length);
    }


    public static void main(String[] args) throws Exception {
        Learn09 learn09 = new Learn09("define_classLoading");
        Class<?> clazz = learn09.loadClass("com.jvm.learn.classLoad.Learn01");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(clazz.getClassLoader());
    }
}
