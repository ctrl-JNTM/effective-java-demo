package com.jntm.a_创建和销毁对象.避免创建不必要的对象;

import java.util.regex.Pattern;

public class Main {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");

    //🌟2
    //要求性能场景下，不建议
    public boolean checkEmailFlase(String email) {
        return email.matches("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
    }

    //java内部会根据正则表达式创建对应的有限状态机对象，上述不建议做法每次调用都创建，且成本过大，建议事先创建正则表达式对象，后续调用无需创建。
    //要求性能场景下，建议
    public boolean checkEmailTrue(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }


    //🌟3
    public static long sum() {
        //下面做法不建议，可以直接使用long，避免装箱拆箱的性能影响
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += 1;
        }
        return sum;
    }


    public static void main(String[] args) {
        //🌟1
        //❌
        String s = new String("str");
        //✅
        String s1 = "str";
    }
}
