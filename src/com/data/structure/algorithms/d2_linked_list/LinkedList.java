package com.data.structure.algorithms.d2_linked_list;

public class LinkedList<T> {

    Node list;
    // 链表中的节点数
    int size;

    public LinkedList() {
        size = 0;
    }
    // 添加节点
    // 在头部添加节点
    public void put(T data) {
        // 创建要添加的节点
        Node curNode = new Node(data, list);
        list = curNode;
        size++;
    }
    // 在链表的 index 索引处添加节点
    // todo 在 0 索引处添加有些问题？
    public void put(int index, T data) {
        checkPositionIndex(index);
        // 当前节点
        Node curr = list;
        // 当前节点的前节点
        Node pre = list;
        for (int i = 0; i < index; i++) {
            pre = curr;
            curr = curr.next;
        }
        Node newNode = new Node(data, curr);
        pre.next = newNode;
        size++;
    }

    // 删除节点
    // 删除头部节点
    public T remove() {
        if (list != null) {
            // 要删除的节点
            Node node = list;
            // 头结点指向下一节点
            list = node.next;
            // 要删除的节点和后继节点解绑，有助于 GC 操作
            node.next = null;
            size--;
            return node.data;
        }
        return null;
    }
    // todo 删除 0 索引有点问题吧
    public T remove(int index) {
        checkPositionIndex(index);
        if (index == 0) {
            return remove();
        }
        Node pre = list;
        Node curr = list;
        for (int i = 0; i < index; i++) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = curr.next;
        curr.next = null;
        size--;
        return curr.data;
    }

    public T removeLast() {
        if (list != null) {
            Node pre = list;
            Node curr = list;
            while (curr.next != null) {
                pre = curr;
                curr = curr.next;
            }
            pre.next = null;
            size--;
            return curr.data;
        }
        return null;
    }

    // 修改节点
    public void set(int index, T newData) {
        checkPositionIndex(index);
        Node curr = list;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.data = newData;
    }

    // 查询节点
    // 获取头部节点
    public T get() {
        Node node = list;
        if (node != null) {
            return node.data;
        }
        return null;
    }

    public T get(int index) {
        checkPositionIndex(index);
        Node curr = list;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public String toString() {
        Node node = list;
        StringBuilder sb = new StringBuilder();
        sb.append("打印所有元素：[");
        for (int i = 0; i < size; i++) {
            sb.append(node.data);
            if (i != size - 1) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new ArrayIndexOutOfBoundsException("index = " + index + ", size = " + size);
        }
    }

    class Node {
        T data;
        Node next;

        public Node(T data, Node node) {
            this.data = data;
            this.next = node;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.put(i);
        }
        System.out.println(list);
        System.out.println("在索引 3 的地方插入 6：");
        list.put(3, 6);
        System.out.println(list);
        System.out.println("删除头部节点：" + list.remove());
        System.out.println(list);
        System.out.println("删除索引 0 的节点：" + list.remove(0));
        System.out.println(list);
        System.out.println("删除尾部节点：" + list.removeLast());
        System.out.println(list);
        System.out.println("删除索引 2 的节点：" + list.remove(2));
        System.out.println(list);
        System.out.println("获取头节点：" + list.get());
        System.out.println("获取索引 1 的节点：" + list.get(1));
    }
}
