package com.jntm.a_创建和销毁对象.避免使用终结方法和清除方法;

import java.lang.ref.Cleaner;

public class Main {
    //✅：避免使用终结方法（finalizer）和清除方法（AutoCloseable）


    public static void main(String[] args) {
        //🌰1：
        //资源在try-with-resource中，最后会执行清除方法
        //所以100%打印：
        // good bye!
        //clean up
        try (Room room = new Room(99)) {
            System.out.println("good bye!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //🌰2：
        //此时有大概率会不执行Room的清除方法，因为此时清除方法只有在room对象被垃圾回收时才会执行。
        //所以打印结果大概率为：
        // good bye!
        new Room(99);
        System.out.println("good bye!");


    }


}
