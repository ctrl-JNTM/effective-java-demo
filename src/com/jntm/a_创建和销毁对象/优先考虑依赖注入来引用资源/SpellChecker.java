package com.jntm.a_创建和销毁对象.优先考虑依赖注入来引用资源;

import java.util.List;
import java.util.function.Supplier;

public class SpellChecker {
    private List<String> dic;

    public void manCher(Supplier<List<String>> supplier) {
        dic = supplier.get();
    }

    public void check() {
        System.out.println(dic.get(0));
    }
}
