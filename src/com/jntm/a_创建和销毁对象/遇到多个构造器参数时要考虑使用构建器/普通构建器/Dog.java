package com.jntm.a_创建和销毁对象.遇到多个构造器参数时要考虑使用构建器.普通构建器;

//Builder模式适适用于普通结构
public class Dog {
    private String male;
    private String speed;
    private String age;
    private String name;
    private String height;
    private String weight;

    public static class Builder {
        private String male;
        private String speed = "0km/h";
        private String age = "1";
        private String name;
        private String height = "0cm";
        private String weight = "0cm";

        public Builder setMale(String male) {
            this.male = male;
            return this;
        }

        public Builder setSpeed(String speed) {
            this.speed = speed;
            return this;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setHeight(String height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(String weight) {
            this.weight = weight;
            return this;
        }

        public Dog build() {
            return new Dog(this);
        }
    }

    public Dog(Builder builder) {
        male = builder.male;
        speed = builder.speed;
        height = builder.height;
        weight = builder.weight;
        age = builder.age;
        name = builder.name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "male='" + male + '\'' +
                ", speed='" + speed + '\'' +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
