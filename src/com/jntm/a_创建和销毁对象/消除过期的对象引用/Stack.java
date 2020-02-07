package com.jntm.a_创建和销毁对象.消除过期的对象引用;

public class Stack {
    private String[] dataList;
    private int size;
    private static final int CAPACITY = 1000 * 1000;

    public Stack() {
        dataList = new String[CAPACITY];
    }

    public void push(String data) {
        dataList[size++] = data;
    }

    //❌ 不建议
    public String popFalse() {
        if (size == 0) {
            throw new RuntimeException("no data!");
        }
        return dataList[--size];
    }

    //⭕️ 建议
    public String popTrue() {
        if (size == 0) {
            throw new RuntimeException("no data!");
        }
        String data = dataList[--size];
        //消除无用对象，否则此位置在下次插入之前会一直存在数据。
        dataList[size] = null;
        return data;
    }
}
