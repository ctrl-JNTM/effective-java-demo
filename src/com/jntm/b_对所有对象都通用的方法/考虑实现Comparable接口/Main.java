package com.jntm.b_对所有对象都通用的方法.考虑实现Comparable接口;

import java.util.Comparator;

public class Main {
    //⚠️：jdk7之后，所有的装箱基本类型中都增加了compare方法，因此在compareTo方法中不建议使用>,<,=,这样的比较符是非常繁琐的且容易出错。


    public static class Dog implements Comparable<Dog> {
        private int age;
        private int length;
        private int high;

        //jdk8引入了比较器构造方法
        //🌰：一个比较Dog的比较器，先后比较age，length，high属性

        public static final Comparator<Dog> comparator = Comparator.comparingInt((Dog x) -> x.age) //(Dog x),java没有强大到足以为自己找出类型
                .thenComparingInt(x -> x.length)
                .thenComparingInt(x -> x.high);

        @Override
        public int compareTo(Dog dog) {
            return comparator.compare(this, dog);
        }
    }


    //反🌰：
    //因为：很容易造成整数溢出，并且与现成的比较方向相比，并没有性能优势
    static Comparator<Object> hashComparatorFan = new Comparator<Object>() {
        @Override
        public int compare(Object o, Object t1) {
            return o.hashCode() - t1.hashCode();
        }
    };

    //正🌰：
    static Comparator<Object> hashComparatorZheng = new Comparator<Object>() {
        @Override
        public int compare(Object o, Object t1) {
            return Integer.compare(o.hashCode(), t1.hashCode());
        }
    };
    //或者使用比较好构造器
    static Comparator<Object> hashComparatorConstruct = Comparator.comparing(Object::hashCode);

    public static void main(String[] args) {
    }
}
