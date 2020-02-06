package com.jntm.a_创建和销毁对象.遇到多个构造器参数时要考虑使用构建器.类级别构建器;

import java.util.EnumSet;
import java.util.Set;

//builder适用于类层次结构
public abstract class Cat {
    public enum Feature {YELLOW, BLACK, WHITE}

    final Set<Feature> features;

    abstract static class Builder<T extends Builder<T>> {
        public EnumSet<Feature> features = EnumSet.noneOf(Feature.class);

        public T addFeature(Feature feature) {
            features.add(feature);
            return self();
        }

        public abstract Cat build();

        public abstract T self();
    }

    public Cat(Builder builder) {
        features = builder.features.clone();
    }
}
