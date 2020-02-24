package com.jntm.c_类和接口.使类和成员的可访问性最小化;

import java.util.List;

public class Main {
    //规则：尽可能的使每个类或者成员不被外界访问

    //包含公有可变域的类通常是线程不安全的

    //让类具有公有的静态final数组域，或者返回这种域的方法，是不合理的，存在安全问题
    //🌰：
    public static final String[] demoArray = {"11", "22", "33"};


    //正确方法：
    //🌰1：
    private static final String[] demoArray1 = {"11", "22", "33"};
    public static final List<String> getList = List.of(demoArray1);

    //🌰2：
    private static final String[] demoArray2 = {"11", "22", "33"};

    public static final String[] getArray() {
        return demoArray2.clone();
    }


    public static void main(String[] args) {
        String[] sd = {"w2", "ew", "rw"};
        String[] sd1 = sd.clone();
        System.out.println(sd == sd1);
        for (int i = 0; i < sd.length; i++) {
            System.out.println(sd[i] == sd1[i]);
        }
    }

}
