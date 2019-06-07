package com.jvm.learn.classLoad;

/**
 *       被final修饰的是常量, 在编译阶段, 这个常量会被保存到调用这个常量的方法所属的类的常量池中.
 *       本质上,  调用类并没有直接引用定义常量的类, 因此不会触发定义常量的类的初始化.
 *       应用到这个demo中, 在编译阶段, 即在编译为.class字节码的时候, Parent03的id属性就被编译到了
 * Learn03类中, jvm在加载连接初始化Learn03类时, Learn03类的常量池中包含id为1的这个常量. 也就是说
 * 编译完成后, Learn03类和Parent03类没有任何关系了, 即便在编译好的文件中删除掉Parent03的.class文件,
 * 只运行Learn03.class字节码文件, 也可以正常运行. 为了验证, 可以在idea中查看Learn03.class文件,
 * 可以发现, id被转换为一个不变的常量数字1了.
 *
 * @Author dabing
 * @Date 2019-06-07 13:57
 **/
public class Learn03 {

    public static void main(String[] args) {
        System.out.println(Parent03.id);
    }
}

class Parent03 {
    public static final int id = 1;
    static {
        System.out.println("parent static block");
    }
}
