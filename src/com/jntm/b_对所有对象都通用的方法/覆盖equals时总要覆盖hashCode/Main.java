package com.jntm.b_对所有对象都通用的方法.覆盖equals时总要覆盖hashCode;

import java.util.List;

public class Main {
    //一个好的散列函数通常倾向于"为不相等的对象产生不相等的散列码"，但是事实上想要达到这样的情形非常困，总会有不同的对象他们的散列码是一样的。
    //不过接近理想并不困难，👇是解决方案

    public static class Dog {
        private String name;
        private int age;
        private List<String> friends;
        private String[] likes;

        @Override
        public int hashCode() {
            //从第一个关键域开始，先计算出hashcode
            int result = name.hashCode();
            //之后按照公式（result = 31*result+c）遍历除第一个关键域以外的其他关键域
            //⚠️：如果关键域为数组，则需要遍历算数组中的每个元素来计算
            //🌰：
            result = 31 * result + Integer.hashCode(age);
            result = 31 * result + friends.hashCode();
            for (String str : likes) {
                result = 31 * result + str.hashCode();
            }
            return result;
        }
    }


    public static class DogLazily {
        private String name;
        private int age;
        private List<String> friends;
        private String[] likes;

        //懒加载模式，并且避免每次调用hashcode方法时都重新计算一遍，适用于不可变对象
        private int hashcode;

        @Override
        public int hashCode() {

            //⚠️：懒加载模式，适用于不可变对象
            int result = hashcode;
            if (result != 0) {
                return result;
            }

            //从第一个关键域开始，先计算出hashcode
            result = name.hashCode();
            //之后按照公式（result = 31*result+c）遍历除第一个关键域以外的其他关键域
            //⚠️：如果关键域为数组，则需要遍历算数组中的每个元素来计算
            //🌰：
            result = 31 * result + Integer.hashCode(age);
            result = 31 * result + friends.hashCode();
            for (String str : likes) {
                result = 31 * result + str.hashCode();
            }
            return result;
        }
    }
}
