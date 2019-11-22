package com.qfedu.b_list;

import java.util.ArrayList;
import java.util.List;

/**
List接口下的常用方法
	增
		add(E e);
			添加指定元素到当前集合的末尾，使用的方式是尾插法
		add(int index, E e);
			在集合中指定位置，添加指定元素，指定下标位置不能超出0 ~ size - 1
		addAll(Collection<? extends E> c);
			添加另一个集合到当前集合的末尾
		addAll(int index, Collection<? extends E> c);
			在集合中的指定下标位置，添加另一个集合，指定下标位置不能超出0 ~ size - 1
	删
		clear();
			清空整个集合
		remove(Object obj);
			删除集合中的指定元素
		remove(int index);
			删除集合中的指定下标元素
		removeAll(Collection<?> c);
			删除两个集合之间的交集
		retainAll(Collection<?> c);
			保留两个集合之间的交集

	改
		E set(int index, E e);
			使用指定元素替换 指定下标的元素，指向下标范围不能超出0 ~ size - 1
	查
		int size();
			获取当前集合中有效元素个数
		boolean isEmpty();
			判断当前集合中的元素是否为0
		boolean contains(Object obj);
			判断指定元素是否包含在集合中
		boolean containsAll(Collection<?> c);
			判断指定的集合是不是当前集合的【子集合】

		int indexOf(Object obj);
			获取指定元素的下标位置，没有找到，返回负数
		int lastIndexOf(Object obj);
			获取指定元素在集合中最后一次出现的下标位置，没有找到，返回负数
		E get(int index);
			获取指定下标对应的元素
		List<E> subList(int fromIndex, int endIndex);
			获取当前集合的子集合 从fromIndex <= 集合 < endIndex。要头不要尾
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
        List没有自己的类对象，这里可以使用List接口的实现类来演示方法
         */
        List<String> list = new ArrayList<>();

        list.add("红星二锅头");
        list.add("牛栏山二锅头");
        list.add("菊花白");
        list.add("茅台飞天");
        list.add("五粮液");

        System.out.println(list);

        list.add(2, "江小白");
        System.out.println(list);

        List<String> list2 = new ArrayList<>();

        list2.add("梦之蓝 M6");
        list2.add("舍得 458RMB");
        list2.add("习酒");
        list2.add("红花郎");

        list.addAll(3, list2);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        String str = list.set(7, "鹿邑14");
        System.out.println(str);
        System.out.println(list);

        System.out.println(list.indexOf("五粮液"));

        list.add("牛栏山二锅头");

        System.out.println(list.lastIndexOf("牛栏山二锅头"));

        System.out.println(list.get(5));

        List<String> strings = list.subList(0, 5);
        System.out.println(strings);

    }
}
