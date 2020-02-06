package com.jntm.a_创建和销毁对象.通过私有构造器强化不可实例化的能力;

public class DogUtils {
    private DogUtils() {
    }

    public static String getYellowDog() {
        return "yellow";
    }
}
