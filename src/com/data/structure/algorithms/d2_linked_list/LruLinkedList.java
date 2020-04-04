package com.data.structure.algorithms.d2_linked_list;

/**
 * LRU 的规则：
 * 1，新数据插入到链表头部；
 * 2，当缓存命中(即缓存数据被访问)，数据要移到表头；
 * 3，当链表满的时候，将链表尾部的数据丢弃。
 * @param <T>
 */
public class LruLinkedList<T> extends LinkedList<T> {
    private int memorySize;
    private static final int DEFAULT_CAP = 5;

    public LruLinkedList(int memorySize) {
        this.memorySize = memorySize;
    }

    public LruLinkedList() {
        this(DEFAULT_CAP);
    }

    // 新数据插入到链表头部
    // 当链表满的时候，将链表尾部的数据丢弃
    public void lruPut(T newData) {
        if (size >= memorySize) {
            removeLast();
        }
        put(newData);
    }
    // 删除是从尾部删除
    public T lruRemove() {
        return removeLast();
    }
    // 当缓存命中(即缓存数据被访问)，数据要移到表头
    public T lruGet(int index) {
        checkPositionIndex(index);
        Node curr = list;
        Node pre = list;
        for (int i = 0; i < index; i++) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = curr.next;
        curr.next = list;
        list = curr;
        return curr.data;
    }

    public static void main(String[] args) {
        LruLinkedList<Integer> list = new LruLinkedList<>(5);
        for (int i = 0; i < 4; i++) {
            list.lruPut(i);
        }
        System.out.println(list);
        System.out.println("获取索引为 2 的元素：" + list.lruGet(2));
        System.out.println(list);
        System.out.println("添加元素 4");
        list.lruPut(4);
        System.out.println(list);
        System.out.println("添加元素 5");
        list.lruPut(5);
        System.out.println(list);

    }
}
