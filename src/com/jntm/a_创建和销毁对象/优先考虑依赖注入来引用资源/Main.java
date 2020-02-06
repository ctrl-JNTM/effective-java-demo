package com.jntm.a_创建和销毁对象.优先考虑依赖注入来引用资源;

public class Main {
    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker();
        spellChecker.manCher(new StringList(true));
        spellChecker.check();
    }
}
