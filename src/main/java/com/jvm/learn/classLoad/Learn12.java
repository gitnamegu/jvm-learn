package com.jvm.learn.classLoad;

import java.io.*;

/**
 *      类的卸载, 添加-XX:+TraceClassUnloading参数可以打印类的卸载信息
 *
 * @Author dabing
 * @Date 2019-06-18 22:26
 **/
public class Learn12 extends ClassLoader {

    private String mineClassLoaderName;

    public Learn12(String mineClassLoaderName) {
        this.mineClassLoaderName = mineClassLoaderName;
    }

    public Learn12(ClassLoader parent, String mineClassLoaderName) {
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
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        String mineClassLoaderName1 = "mineClassLoaderName";
        Learn12 learn11_1 = new Learn12(mineClassLoaderName1);
        String classPath = "/Users/dabing/jvm/Demo.class";
        Class<?> clazz1 = learn11_1.loadClass(classPath);
        System.out.println("class:" + clazz1.hashCode());

        learn11_1 = null;
        clazz1 = null;
        System.gc();
        Thread.sleep(200000L);


    }
}
