package com.qfedu.c_arraylist;

import java.util.Arrays;

public class MyArrayList<E> {
    /**
     * 底层保存数据的Object类型数组，可以保存任意类型元素
     */
    private Object[] elementData = null;

    /**
     * 底层数组的初始化容量，这里指定为10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 最大数组容量
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 保存当前集合中的有效元素个数
     */
    private int size = 0;

    /**
     * 无参构造方法，实际执行的是代码中的带有int类型参数的构造方法，
     * 让整个代码的初始化过程更加统一，同时能够满足更好的代码阅读性
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 带有底层数组容量初始化的参数的构造方法
     *
     * @param initCapacity 指定的底层数组容量，不能小于0，不能大于MAX_ARRAY_SIZE
     */
    public MyArrayList(int initCapacity) {
        if (initCapacity < 0 || initCapacity > MAX_ARRAY_SIZE) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            elementData = new Object[initCapacity];
        }
    }

    /**
     * 添加指定元素到集合的末尾
     *
     * @param e 指定元素
     * @return 添加成功返回true
     */
    public boolean add(E e) {
        return add(size, e);
    }

    /**
     * 添加指定元素到集合中的指定下标位置
     *
     * @param index 指定的下标位置
     * @param e     指定元素
     * @return 添加成功返回true
     */
    public boolean add(int index, E e) {
        securityCheck(index);

        if (size == elementData.length) {
            grow(size + 1);
        }

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

        elementData[index] = e;
        size++;

        return true;
    }

    /**
     * 删除集合中指定的元素
     *
     * @param obj 指定的元素
     * @return 是否删除成功
     */
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        return index >= 0 && remove(index);
    }

    /**
     * 删除指定下标的元素
     *
     * @param index 指定下标
     * @return 删除成功返回true
     */
    public boolean remove(int index) {
        securityCheck(index);

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        elementData[size - 1] = null;
        size -= 1;

        return true;
    }

    /**
     * 清空整个集合中的所有元素
     */
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;

        // 申请调用JVM的GC垃圾回收机制
        System.gc();
    }

    /**
     * 使用指定元素替换指定下标的元素
     *
     * @param index 指定下标的元素
     * @param e     指定的元素
     * @return 被替换的元素
     * @throws ArrayIndexOutOfBoundsException 数组下标越界异常
     */
    public E set(int index, E e) {
        securityCheck(index);

        E temp = this.get(index);

        elementData[index] = e;

        return temp;
    }

    /**
     * 获取当前集合中的有效元素个数
     *
     * @return 返回值是当前集合中的有效元素个数
     */
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    /**
     * 获取指定下标的元素
     *
     * @param index 指定的下标
     * @return 对应下标的元素
     */
    public E get(int index) {
        securityCheck(index);
        return (E) elementData[index];
    }

    /**
     * 获取当前集合所有元素的Object类型数组
     *
     * @return 集合内所有元素的Object类型数组
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * 判断指定元素是否在集合中存在
     *
     * @param obj 指定的元素
     * @return 存在，返回true，否则返回false
     */
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /**
     * 判断集合中是否有元素
     *
     * @return 有返回false，没有返回true
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取指定元素在集合中下标位置，没有找到返回负数
     *
     * @param obj 指定的元素
     * @return 找到返回值大于等于0，没有找到，返回负数
     */
    public int indexOf(Object obj) {
        if (null == obj) {
            return -1;
        }

        int index = -1;
        for (int i = 0; i < size; i++) {
            /*
             * equals方法是判断两个对象是否相同，建议使用equals方法来比较对象
             * 后期会讲解equals使用规范和重写要求
             */
            if (obj.equals(elementData[i])) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * 找出指定元素在集合中最后一次出现的位置
     *
     * @param obj 指定的元素
     * @return 找到返回值大于等0，没有找到返回负数
     */
    public int lastIndexOf(Object obj) {
        if (null == obj) {
            return -1;
        }

        int index = -1;
        for (int i = size - 1; i >= 0; i--) {
            /*
             * equals方法是判断两个对象是否相同，建议使用equals方法来比较对象
             * 后期会讲解equals使用规范和重写要求
             */
            if (obj.equals(elementData[i])) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * 获取MyArrayList子集合对象，数据范围是从fromIndex 到 endIndex，要头不要尾
     *
     * @param fromIndex 数据获取的起始点
     * @param endIndex  数据获取的终点，但是不包含终点
     * @return MyArrayList对象
     */
    public MyArrayList<E> subList(int fromIndex, int endIndex) {

        if (endIndex <= fromIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // 创建的临时MyArrayList对象
        MyArrayList<E> temp = new MyArrayList<>(endIndex - fromIndex);

        // 使用for循环，从MyArrayList集合中读取fromIndex 到 endIndex直接的元素
        for (int i = fromIndex; i < endIndex; i++) {
            /*
            this表示调用当前方法的MyArrayList对象
             */
            temp.add(this.get(i));
        }

        return temp;
    }

    /**
     * 可变长数组的扩容的核心方法，新数组容量大约是原数组容量的1.5倍，但是不能小于
     * minCapacity要求
     *
     * @param minCapacity 要求的最小容量
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;

        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }

        if (newCapacity > MAX_ARRAY_SIZE) {
            throw new ArrayIndexOutOfBoundsException();
        }

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 截取当前底层Object数组容量和size有效元素个数一致
     */
    public void trimToSize() {
        elementData = Arrays.copyOf(elementData, size);
    }

    /**
     * 类内的私有化下标范围检查方法
     *
     * @param index 指定的下标位置
     */
    private void securityCheck(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
