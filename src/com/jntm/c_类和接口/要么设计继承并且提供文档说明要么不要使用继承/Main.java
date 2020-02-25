package com.jntm.c_类和接口.要么设计继承并且提供文档说明要么不要使用继承;

import java.time.LocalDate;

public class Main {
    //⚠️：必须要有文档说明可继承的类，他可覆盖的方法的自用性。

    //反🌰：
    public static class Super {
        public Super() {
            output();
        }

        public void output() {
        }

    }


    public static class Sub extends Super {
        private final LocalDate localDate;

        public Sub() {
            localDate = LocalDate.now();
        }

        @Override
        public void output() {
            System.out.println(localDate);
        }
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.output();
        //期望以上代码会打印两次日期，实际上第一次会打印null，第二次打印日期

        //⚠️：通过构造器调用私有的方法，final方法，和静态方法是合理的，这些都不是可以被覆盖的。
        //类似于构造器，clone方法或者readObject方法都不可以调用可覆盖的方法，不管是间接调用还是直接调用。
        //对于那些并非安全子类化而设计和编写文档的类，要禁止子类化。
    }
}
