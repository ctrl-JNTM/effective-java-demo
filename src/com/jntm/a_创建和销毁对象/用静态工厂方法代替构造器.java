package com.jntm.a_创建和销毁对象;

import java.time.Instant;
import java.util.Date;

public class 用静态工厂方法代替构造器 {

    public static void main(String[] args) {
        //1.用静态工厂方法代替构造器，例：
        Dog dog = Dog.create(2, "melon");
        Boolean value = Boolean.valueOf("true");
        Date now = Date.from(Instant.now());
    }

    public static class Dog {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public Dog setAge(int age) {
            this.age = age;
            return this;
        }

        public String getName() {
            return name;
        }

        public Dog setName(String name) {
            this.name = name;
            return this;
        }

        //1.用静态工厂方法代替构造器
        //好处：
        // 1.有名称，易于阅读，易于使用
        //2.可适用于单例模式，不必再每次调用的时候产生新对象
        //3.可以返回原类型的任何子类型对象
        //4.取决于静态工厂方法的参数值，返回的对象可以随每次调用发生变化
        //5.方法所属的类在编写静态工厂方法的时候可以不存在
        public static Dog create(int age, String name) {
            return new Dog().setAge(age).setName(name);
        }
    }


}
