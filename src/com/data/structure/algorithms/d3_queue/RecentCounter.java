package com.data.structure.algorithms.d3_queue;

class RecentCounter {

    public RecentCounter() {
        
    }
    private Node head;
    private int size;
    public int ping(int t) {
        Node node = new Node(t, null);
        // 增加新的节点到尾部
        if (head == null) {
            head = node;
            size++;
            return 1;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            size++;
            Node rail = curr;
            rail.next = node;
        }

        // 在头部删除不再[t - 3000, t] 区间内的节点
        Node curr = head;
        Node pre = null;
        while (curr != null) {
            if (t - curr.time < 3000) {
                // 从头部开始查找，找到第一个在 [t - 3000, t] 内的节点
                break;
            }
            size--;
            pre = curr;
            curr = curr.next;
        }
        head = curr;
        pre.next = null;
        return size;
    }

    class Node {
        Integer time;
        Node next;

        public Node(Integer time, Node next) {
            this.time = time;
            this.next = next;
        }
    }
}