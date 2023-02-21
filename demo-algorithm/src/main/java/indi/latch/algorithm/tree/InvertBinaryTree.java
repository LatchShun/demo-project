package indi.latch.algorithm.tree;

import java.util.Objects;

/**
 * Title: InvertBinaryTree
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/15
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class InvertBinaryTree {
    private static volatile int flag = 0;

    public static void main(String[] args) {
        print();
    }

    private static void print() {
        Thread thread1 = new Thread(() -> {
            char ch = 'a';
            while (ch <= 'z') {
                if (flag == 0) {
                    System.out.print(ch);
                    ch++;
                    flag = 1;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            int i = 1;
            while(i <= 26) {
                if (flag == 1) {
                    System.out.print(i);
                    i++;
                    flag = 0;
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode();
        root.setVal(4);

        TreeNode left = new TreeNode();
        left.setVal(3);
        root.setLeft(left);

        TreeNode right1 = new TreeNode();
        right1.setVal(5);
        left.setRight(right1);
        return root;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        swapLeftRight(root);
        return root;
    }

    private static void swapLeftRight(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        TreeNode left = node.getLeft();
        TreeNode right = node.getRight();
        TreeNode swapNode = left;
        node.left = right;
        node.right = swapNode;

        swapLeftRight(node.left);
        swapLeftRight(node.right);
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
