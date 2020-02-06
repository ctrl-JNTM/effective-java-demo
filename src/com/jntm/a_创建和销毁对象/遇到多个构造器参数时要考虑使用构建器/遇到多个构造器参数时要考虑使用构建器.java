package com.jntm.a_创建和销毁对象.遇到多个构造器参数时要考虑使用构建器;

import com.jntm.a_创建和销毁对象.遇到多个构造器参数时要考虑使用构建器.普通构建器.Dog;
import com.jntm.a_创建和销毁对象.遇到多个构造器参数时要考虑使用构建器.类级别构建器.Cat;
import com.jntm.a_创建和销毁对象.遇到多个构造器参数时要考虑使用构建器.类级别构建器.OrangeCat;

public class 遇到多个构造器参数时要考虑使用构建器 {
    public static void main(String[] args) {
        Dog dog = new Dog.Builder().setName("melon").setMale("母").build();
        System.out.print("dog: " + dog);

        //builder适用于类层次结构
        OrangeCat orangeCat = new OrangeCat.Builder().setMale(1).addFeature(Cat.Feature.YELLOW).build();
        System.out.println(orangeCat);
    }
}
