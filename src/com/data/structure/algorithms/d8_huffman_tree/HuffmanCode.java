package com.data.structure.algorithms.d8_huffman_tree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://mp.weixin.qq.com/s/3uCQj0-WBXENZyr1mQ1mZQ
 * <p>
 * 借助哈夫曼树生成的二进制编码，就是哈夫曼编码。
 *
 * @author wangzhichao
 * @since 2021/2/22
 */
public class HuffmanCode {
    private Node root;
    private Node[] nodes;

    public void createHuffmanTree(int[] weights) {
        // 优先队列，用于构建哈夫曼树的辅助队列
        Queue<Node> nodeQueue = new PriorityQueue<>();
        nodes = new Node[weights.length];

        // 构建森林
        for (int i = 0; i < weights.length; i++) {
            nodes[i] = new Node(weights[i]);
            nodeQueue.add(nodes[i]);
        }
        // 主循环，当结点队列只剩一个结点时结束
        while (nodeQueue.size() > 1) {
            // 从结点队列选择权值最小的两个结点
            Node left = nodeQueue.poll();
            Node right = nodeQueue.poll();
            // 创建新结点，作为两个结点的父结点
            Node parent = new Node(left.weight + right.weight, left, right);
            nodeQueue.add(parent);
        }
        root = nodeQueue.peek();
    }

    /**
     * 根据字符下标，得出对应的哈夫曼编码
     *
     * @param index 字符下标
     * @return 哈夫曼编码
     */
    public String convertHuffmanCode(int index) {
        return nodes[index].code;
    }

    public void encode(Node node, String code) {
        if (node == null) {
            return;
        }
        node.code = code;
        encode(node.lChild, node.code + "0");
        encode(node.rChild, node.code + "1");
    }

    public static class Node implements Comparable<Node> {
        int weight;
        // 结点对应的二进制编码
        String code;
        Node lChild;
        Node rChild;

        public Node(int weight) {
            this.weight = weight;
        }

        public Node(int weight, Node lChild, Node rChild) {
            this.weight = weight;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};
        int[] weights = {2, 3, 7, 9, 18, 25};
        HuffmanCode huffmanCode = new HuffmanCode();
        huffmanCode.createHuffmanTree(weights);
        huffmanCode.encode(huffmanCode.root, "");
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] + ":" + huffmanCode.convertHuffmanCode(i));
        }
    }
}
