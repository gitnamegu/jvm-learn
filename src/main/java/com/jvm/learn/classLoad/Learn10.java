package com.jvm.learn.classLoad;

import java.io.*;

/**
 * 自定义类加载器, 使用自定义的类加载器来加载类.
 * @Author dabing
 * @Date 2019-06-18 22:26
 **/
public class Learn10 extends ClassLoader {

    private String mineClassLoaderName;

    public Learn10(String mineClassLoaderName) {
        this.mineClassLoaderName = mineClassLoaderName;
    }

    public Learn10(ClassLoader parent, String mineClassLoaderName) {
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
     *      所要加载的字节码不在项目的classpath下, 而是一个本地文件. 所以在父亲委托时, 根类加载器/扩展类
     * 加载器/系统类加载器无法加载, 父亲加载不成功, 会执行自定义类加载器相关的代码来加载.
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        String mineClassLoaderName = "mineClassLoaderName";
        Learn10 learn10 = new Learn10(mineClassLoaderName);
        String classPath = "/Users/dabing/jvm/Learn02.class";
        Class<?> clazz = learn10.loadClass(classPath);
        System.out.println("class:" + clazz);
    }
}
