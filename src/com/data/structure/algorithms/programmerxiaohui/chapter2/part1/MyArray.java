package com.data.structure.algorithms.programmerxiaohui.chapter2.part1;

/**
 * Array add delete modify query
 *
 * @author wangzhichao
 * @date 7/27/20
 */
public class MyArray {
    private int[] array;
    /**
     * 数组中实际元素的数量
     */
    private int size;

    /**
     * 构造方法
     *
     * @param capacity 数组的容量
     */
    public MyArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    /**
     * 向数组中插入元素
     *
     * @param element 插入的元素
     * @param index   插入的位置
     * @throws Exception
     */
    public void insert(int element, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入元素的位置超出数组中实际元素范围[0, " + size + "], index: " + index);
        }
        if (size == array.length) {
            // 扩容
            ensureCapacity();
        }
        if (index != size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 删除元素
     *
     * @param index 删除的位置
     * @return 删除的位置上元素的值
     * @throws Exception
     */
    public int delete(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("删除元素的位置超出数组中实际元素索引范围[0, " + (size - 1) + "], index: " + index);
        }
        int result = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return result;
    }

    /**
     * 更新元素
     *
     * @param element 新的元素值
     * @param index 更新的位置
     * @throws Exception
     */
    public void set(int element, int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("更新元素的位置超出数组中实际元素索引范围[0, " + (size - 1) + "], index: " + index);
        }
        array[index] = element;
    }

    /**
     * 获取元素
     *
     * @param index 获取的位置
     * @return 获取的位置上元素的值
     * @throws Exception
     */
    public int get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("更新元素的位置超出数组中实际元素索引范围[0, " + (size - 1) + "], index: " + index);
        }
        return array[index];
    }

    private void ensureCapacity() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void print() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        MyArray array = new MyArray(7);
        // 插入元素
        System.out.println("插入元素:");
        array.insert(6, 0);
        array.insert(5, 1);
        array.insert(4, 2);
        array.insert(1, 3);
        array.insert(2, 4);
        array.print();
        array.insert(3, 3);
        array.print();
        array.insert(7, 3);
        array.print();
        array.insert(8, 7);
        array.print();
        array.insert(10, 0);
        array.print();
//        try {
//            array.insert(11, 10);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // 更新元素
        System.out.println("更新元素:");
        array.set(-1, 1);
        array.print();
        // 获取元素
        System.out.println("获取元素: ");
        System.out.println("获取1号元素：" + array.get(1));
        // 删除元素
        System.out.println("删除元素:");
        System.out.println("删除0号元素：" + array.delete(0));
        array.print();
        System.out.println("删除2号元素：" + array.delete(2));
        array.print();
        System.out.println("删除6号元素：" + array.delete(6));
        array.print();
        System.out.println("删除4号元素：" + array.delete(4));
        array.print();
        System.out.println("删除1号元素：" + array.delete(1));
        array.print();
        System.out.println("删除3号元素：" + array.delete(3));
        array.print();
        System.out.println("删除1号元素：" + array.delete(1));
        array.print();
        System.out.println("删除1号元素：" + array.delete(1));
        array.print();
        System.out.println("删除0号元素：" + array.delete(0));
        array.print();

    }

}
