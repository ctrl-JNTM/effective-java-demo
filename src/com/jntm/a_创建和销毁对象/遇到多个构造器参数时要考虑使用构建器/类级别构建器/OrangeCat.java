package com.jntm.a_创建和销毁对象.遇到多个构造器参数时要考虑使用构建器.类级别构建器;

public class OrangeCat extends Cat {
    private int male;

    public static class Builder extends Cat.Builder<Builder> {
        private int male;

        public Builder setMale(int male) {
            this.male = male;
            return this;
        }

        @Override
        public OrangeCat build() {
            return new OrangeCat(this);
        }

        @Override
        public Builder self() {
            return this;
        }
    }

    public OrangeCat(Builder builder) {
        super(builder);
        male = builder.male;
    }

    @Override
    public String toString() {
        return "OrangeCat{" +
                "male=" + male +
                ", features=" + features +
                '}';
    }
}
