package com.qfedu.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo2 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();

        c.add("糖醋排骨");
        c.add("宫保鸡丁");
        c.add("酱肘子");
        c.add("酱牛肉");
        c.add("道口烧鸡");

        Iterator<String> iterator = c.iterator();

        /*
        ConcurrentModificationException
        当前集合中的元素存在两种方式操作
            1. 集合本身的对象
            2. 迭代器对象
            只要有一方操作数据，都会影响到对方的使用。

        目前有没有解决方案:
            没有
            差别操作
         */
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            c.remove("宫保鸡丁");
        }
    }
}
