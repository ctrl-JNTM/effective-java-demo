package com.jntm.a_创建和销毁对象.使用私有构造器或者枚举类型强化单例属性;

//使用私有构造器构造单例
public class Dog {
    private static final Dog singleton = new Dog();

    private Dog() {
    }

    public static Dog getInstance() {
        return singleton;
    }
}
