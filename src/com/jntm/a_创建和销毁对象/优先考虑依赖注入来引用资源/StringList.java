package com.jntm.a_创建和销毁对象.优先考虑依赖注入来引用资源;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class StringList implements Supplier<List<String>> {

    private boolean flag;

    public StringList(boolean flag) {
        this.flag = flag;
    }

    @Override
    public List<String> get() {
        if (flag) {
            return Collections.singletonList("oo");
        }
        return Collections.singletonList("xx");
    }
}
