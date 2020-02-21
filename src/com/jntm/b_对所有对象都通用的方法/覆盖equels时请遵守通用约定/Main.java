package com.jntm.b_对所有对象都通用的方法.覆盖equels时请遵守通用约定;

public class Main {
    //equals通用约定
    //1.自反性：x.equals(x) 必须为true
    //🌰：略

    //2.对称性: x.equals(y)的结果等于y.equals(x)
    //🌰：略

    //3.传递性： x.equals(y)=true且y.equals(z)=true则x.equals(z)=true
    //🌰：略


    //4.非空性： 任何值.equals(null)=false
    //🌰：
    public boolean 重写的equals方法4(Object o) {
        //❌不建议这么写
        if (null == o) {
            return false;
        }

        //✅建议这么写
        //instanceof自带空校验
        if (!(o instanceof Main)) {
            return false;
        }

        //do something
        return true;
    }

    //5.一致性：多次调用x.equals(y)结果一致
    //🌰：略


    //⚠️⚠️⚠️：再编写完equals方法后务必回顾是否满足以上约定。甚至编写单元测试验证。

    //💣：覆盖equals是，总是需要覆盖hashcode方法
    //💣：不要企图让equals方法过于智能
    //💣：不要将equals方法参数中的Object对象替换成其他的类型
}
