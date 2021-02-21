package com.data.structure.algorithms.d8_huffman_tree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653202401&idx=1&sn=319b8d8bf51d3e79d56d212a6b24b2c4&chksm=8c99d53bbbee5c2d24aac1edbbe35e80919ae716637a3897398d26ac9fd0ac0d35ab7ec111d7&mpshare=1&scene=1&srcid=0221G4dJDtVO43qRFutPcKE3&sharer_sharetime=1613911406732&sharer_shareid=adb9e59d4aa18d8881d59cf9c7b8f7ee&key=62c41e64106ff5d3577c4858105737d47a52b4518e7bd25c2ffa40a324ff3f4c88cbb4f714b73631aef63e62eaf69136ca22c98de62291d30c1ed5971ab1c7421af9bafe1d03d781e484469c64fbb8dff11f8ae3d3ea67bd660757ebf6c7d62062734f8eac317d4b1c584375c1368f61216bc133b6bfc3fd4d71c25ae19393c9&ascene=1&uin=MjE0MzgxMjQzMA%3D%3D&devicetype=Windows+10+x64&version=63010043&lang=zh_CN&exportkey=ASJx2ZbSRkWbF6KViYxNQ08%3D&pass_ticket=SmfoKm%2Bv4dGHM0x21Y0NRSJaO4jUh4kxmIoVBm%2B%2Bo3RlbRr4jJ6RXVPGq49qE0IN&wx_header=0
 * <p>
 * 哈夫曼树是在叶子结点和权重确定的情况下，带权路径长度最小的二叉树，也被成为最优二叉树。
 *
 * @author wangzhichao
 * @since 2021/2/22
 */
public class HuffmanTree {
    private Node root;
    public void createHuffman(int[] weights) {
        // 优先队列，用于构建哈夫曼树的辅助队列
        Queue<Node> nodeQueue = new PriorityQueue<>();
        // 构建森林
        for (int weight : weights) {
            nodeQueue.add(new Node(weight));
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
    public void output(Node head) {
        if (head == null) {
            return;
        }

        System.out.println(head.weight);
        if (head.lChild != null) {
            System.out.print("left child:");
            output(head.lChild);
        }
        if (head.rChild != null) {
            System.out.print("right child:");
            output(head.rChild);
        }
    }

    public static class Node implements Comparable<Node> {
        int weight;
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
        int[] weights = {2, 3, 7, 9, 18, 25};
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.createHuffman(weights);
        huffmanTree.output(huffmanTree.root);
    }
}
