package com.data.structure.algorithms.programmerxiaohui.chapter2.part2;

/**
 * 单链表的基本操作： 增 删 改 查
 *
 * @author wangzhichao
 * @date 7/28/20
 */
public class MyLinkedList {
    /**
     * 头节点指针：指向头节点的指针
     */
    private Node head;
    /**
     * 尾节点指针：指向尾节点的指针
     * <p>
     * 这是为了尾部插入的方便而额外增加的
     */
    private Node last;

    /**
     * 链表实际的长度
     */
    private int size;

    /**
     * 插入操作
     * <p>
     * 头部插入
     * 尾部插入
     * 中间插入
     *
     * @param index
     * @param data
     * @throws Exception
     */
    public void insert(int index, int data) throws Exception {
        if ((index < 0 || index > size)) {
            throw new IllegalArgumentException("插入元素的位置超出可插入的范围：[0, " + size + "], index=" + index);
        }
        Node insertedNode = new Node(data);
        if (size == 0) {
            // 链表还为空
            head = insertedNode;
            last = insertedNode;
            size = 1;
            return;
        }
        // 插入位置分类
        if (index == 0) {
            // 头部插入
            insertedNode.next = head;
            head = insertedNode;
        } else if (index == size) {
            // 尾部插入
            last.next = insertedNode;
            last = insertedNode;
        } else {
            // 中间插入
            Node preNode = get(index - 1);
            Node currNode = preNode.next;
            preNode.next = insertedNode;
            insertedNode.next = currNode;
        }
        size++;
    }

    /**
     * 删除操作
     * <p>
     * 尾部删除
     * 头部删除
     * 中间删除
     *
     * @param index
     * @return
     * @throws Exception
     */
    public int delete(int index) throws Exception {
        if ((index < 0 || index >= size)) {
            throw new IllegalArgumentException("删除元素的位置超出可删除的范围：[0, " + (size - 1) + "], index=" + index);
        }
        int result;
        if (index == 0) {
            // 头部删除
            result = head.data;
            Node newHead = head.next;
            head.next = null;
            head = newHead;
        } else if (index == size - 1) {
            // 尾部删除
            Node preNode = get(index - 1);
            result = preNode.next.data;
            preNode.next = null;
            last = preNode;
        } else {
            // 中间删除
            Node preNode = get(index - 1);
            Node targetNode = preNode.next;
            result = targetNode.data;
            preNode.next = targetNode.next;
        }
        size--;
        return result;
    }

    /**
     * 更新操作
     *
     * @param index
     * @param data
     * @throws Exception
     */
    public void update(int index, int data) throws Exception {
        Node node = get(index);
        node.data = data;
    }

    /**
     * 查询操作
     *
     * @param index
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if ((index < 0 || index >= size)) {
            throw new IllegalArgumentException("查询元素的位置超出可查询的范围：[0, " + (size - 1) + "], index=" + index);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 获取链表的长度
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 输出
     */
    public void output() {
        Node currNode = head;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(currNode.data);
            currNode = currNode.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList linkedList = new MyLinkedList();
        System.out.println("插入操作：");
        linkedList.insert(0, 1);
        linkedList.output();
        linkedList.insert(1, 2);
        linkedList.output();
        linkedList.insert(0, 3);
        linkedList.output();
        linkedList.insert(1, 4);
        linkedList.output();
        linkedList.insert(2, 5);
        linkedList.output();
        linkedList.insert(3, 6);
        linkedList.output();
        System.out.println("删除操作：");
        System.out.println("删除头部元素：" + linkedList.delete(0));
        linkedList.output();
        System.out.println("删除尾部元素：" + linkedList.delete(4));
        linkedList.output();
        System.out.println("删除2号元素：" + linkedList.delete(2));
        linkedList.output();
        System.out.println("查询操作：");
        System.out.println("查询1号元素：" + linkedList.get(1).data);
        System.out.println("更新操作：");
        System.out.println("更新1号元素：");
        linkedList.update(1, 100);
        linkedList.output();
    }
}
