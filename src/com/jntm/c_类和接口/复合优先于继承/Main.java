package com.jntm.c_类和接口.复合优先于继承;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    //⚠️：与方法调用不同的是，继承打破了封装性，换句话说，子类依赖于基类中特定的功能的实现细节，如果基类发生变化，子类可能因此遭受到破坏。

    //复合:不扩展现有类，而是在一个新的类中增加一个私有域，它引用现有类的一个实例
    //正🌰：这个类把一个Set转换成另一个Set,同时增加了计数功能
    public static class ForwardingSet<E> implements Set<E> {
        public final Set<E> set;

        public ForwardingSet(Set<E> set) {
            this.set = set;
        }


        @Override
        public int size() {
            return set.size();
        }

        @Override
        public boolean isEmpty() {
            return set.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return set.contains(o);
        }

        @Override
        public Iterator<E> iterator() {
            return set.iterator();
        }

        @Override
        public Object[] toArray() {
            return set.toArray();
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            return set.toArray(ts);
        }

        @Override
        public boolean add(E e) {
            return set.add(e);
        }

        @Override
        public boolean remove(Object o) {
            return set.remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return set.containsAll(collection);
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            return set.addAll(collection);
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return set.retainAll(collection);
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return set.removeAll(collection);
        }

        @Override
        public void clear() {
            set.clear();
        }
    }


    public static class InstrumentedSet<E> extends ForwardingSet<E> {

        private int addCount;

        public InstrumentedSet(Set<E> set) {
            super(set);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> collection) {
            addCount += collection.size();
            return super.addAll(collection);
        }

        public int getAddCount() {
            return addCount;
        }
    }


    //反🌰：使用继承
    public static class AddCountSet<E> extends HashSet<E> {
        private int addCount;

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public AddCountSet(int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
        }

        public int getAddCount() {
            return addCount;
        }
    }

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        //正🌰：
        InstrumentedSet<Integer> integers = new InstrumentedSet<Integer>(hashSet);
        integers.add(11);
        integers.add(111);
        System.out.println(integers.addCount); //2

        //反🌰：
        AddCountSet<Integer> addCountSet = new AddCountSet<>(3,3);
        addCountSet.add(1);
        addCountSet.addAll(hashSet);//因为hashset的addall方法原理是循环调用add 所以该类计数器的结果不正确
        System.out.println(addCountSet.addCount);


    }

}
