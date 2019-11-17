package com.soup.memo.algorithm.datastructure;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  数组操作 <br/>
 *    读取：随机读取，通过数组下标读取元素，时间复杂度O(1)
 *    更新：利用数组下标，将新值赋值给该下标的元素，时间复杂度O(1)
 *    插入：尾插、中插、超范围插入
 *    删除：时间复杂度：O(n)
 *      还有一种删除方式，将数组最后一个元素覆盖到待删除的位置，然后删除最后一个元素，这样就无需移动元素，时间复杂度：O(1)
 * </p>
 *
 * @author zhaoyi
 * @date 2019-11-17 20:44
 * @since 1.0
 */
@Slf4j
@Data
public class ArrayManipulate<T> {
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayManipulate(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 数组插入，容量不足时进行扩容操作，时间复杂度：O(n)
     *
     * @param element 待插入元素
     * @param index 待插入位置
     */
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }

        if (size >= array.length) {
            // 数组扩容，扩容的时间复杂度：O(n)
            resize();
        }

        // 元素右移，时间复杂度：O(n)
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    /**
     * 输入组扩容
     */
    public void resize() {
        @SuppressWarnings("unchecked")
        T[] arrayNew = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 数组删除，时间复杂度：O(n) <br/>
     * 还有一种删除方式，
     *
     * @param index 待删除的元素的下标
     * @return 删除的元素
     */
    public T delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界");
        }

        T deltedElement = array[index];
        // 数组元素左移
        for (int i = index; i <= size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deltedElement;
    }

    /**
     * 数组删除: 将数组最后一个元素覆盖到待删除的位置，然后删除最后一个元素，这样就无需移动元素，时间复杂度：O(1)
     * @param index 待删除的元素的下标
     * @return 删除的元素
     */
    public T deleteNoMove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        T deleteElement = array[index];
        // 将最后一个元素放到待删除的位置上，并将最后一个元素删除
        array[index] = array[size - 1];
        array[size - 1] = null;
        size--;
        return deleteElement;
    }
}
