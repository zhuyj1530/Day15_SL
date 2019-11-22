package com.qfedu.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo1 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();

        c.add("烤羊排");
        c.add("生命之水");
        c.add("大乌苏");
        c.add("老雪");

        /*
        Iterator<E> 接口

        Iterator<E> iterator() 通过集合获取对应的迭代器对象

        boolean hasNext();
            判断当前迭代器是否可以继续运行
        E next();
            获取当前迭代器指向的元素，并且指向下一个元素
        void remove();
            删除
                【注意】
                 删除方法，只能删除通过next方法获取的元素，并且是在调用remove方法之前
                 必须有一个next方法
                 一对一关系，不能跳过代码


        Iterator<String> iterator = c.iterator();
        System.out.println("是否可以继续遍历：" + iterator.hasNext());
        System.out.println("next: " + iterator.next());
        System.out.println("next: " + iterator.next());
        iterator.remove();
        iterator.remove();

        System.out.println(c);
        */

        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }

        System.out.println(c);
        System.out.println(c.isEmpty());
    }
}
