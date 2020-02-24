package com.jntm.b_对所有对象都通用的方法.谨慎地覆盖clone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    //💡事实上，实现cloneable接口的类是为了提供一个功能适当的共有clone方法
    //💡不可变的类永远都不应该提供clone方法
    //💡clone就是另一个构造器，必须确保他不会伤害到原始的对象，并正确的创建被克隆对象中的约束条件
    //💡cloneable架构与引用可变对象的final域的正常用法是相互冲突的,除非原对象和克隆对象中此变量可以共享，否贼为了使类可以被克隆，有必要从某些域中去掉final修饰符
    //💡对象拷贝的更好方法是采用拷贝构造器或者拷贝工厂（详见第一章第一条静态工厂），因为他们不存在clone的约束
    //🌰
    public static class Cat implements Cloneable {
        //💡cloneable架构与引用可变对象的final域的正常用法是相互冲突的,除非原对象和克隆对象中此变量可以共享，否贼为了使类可以被克隆，有必要从某些域中去掉final修饰符
        private final String[] friends = {"tiangua", "musi"};
        //💡cloneable架构与引用可变对象的final域的正常用法是相互冲突的,除非原对象和克隆对象中此变量可以共享，否贼为了使类可以被克隆，有必要从某些域中去掉final修饰符
        private final String species = "cat";
        private String name;
        private List<String> families;

        public String getSpecies() {
            return species;
        }

        public String getName() {
            return name;
        }

        public Cat setName(String name) {
            this.name = name;
            return this;
        }

        public String[] getFriends() {
            return friends;
        }

        public List<String> getFamilies() {
            return families;
        }

        public Cat setFamilies(List<String> families) {
            this.families = families;
            return this;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "friends=" + Arrays.toString(friends) +
                    ", species='" + species + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + families +
                    '}';
        }

        @Override
        protected Cat clone() {
            try {
                Cat cat = (Cat) super.clone();
                return cat;
            } catch (CloneNotSupportedException e) {
                //共有的clone方法应该省略throw声明，不抛出受检异常使方式用起来更加轻松
                throw new RuntimeException();
            }
        }
    }


    public static void main(String[] args) {
        Cat cat = new Cat().setName("可乐").setFamilies(new ArrayList<>());
        Cat cat1 = cat.clone();
        System.out.println(cat);
        System.out.println(cat1);
        System.out.println(cat == cat1);
        System.out.println(cat.getFriends() == cat1.getFriends());
        System.out.println(cat.getName() == cat1.getName());
        System.out.println(cat.getSpecies() == cat1.getSpecies());
        System.out.println(cat.getFamilies() == cat1.getFamilies());
    }
}
