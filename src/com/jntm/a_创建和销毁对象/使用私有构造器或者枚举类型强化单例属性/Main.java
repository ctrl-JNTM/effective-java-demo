package com.jntm.a_创建和销毁对象.使用私有构造器或者枚举类型强化单例属性;

public class Main {
    public static void main(String[] args) {
        //编译错误Dog dog = new Dog();
        Dog dog = Dog.getInstance();

        //枚举本身就是单例
        Cat cat = Cat.INSTANCE;
    }
}
