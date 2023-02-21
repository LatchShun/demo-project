package indi.latch.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Title: BinarySearchTreeAlgorithmDemo
 * Description: 二叉搜索树
 * Copyright: 数禾科技 Copyright(c) 2023/2/1
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class BinarySearchTreeAlgorithmDemo {

    public static void main(String[] args) {
        List<Integer> list = IntStream.range(1, 7).boxed().collect(Collectors.toList());
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(list);

        List<Integer> preOrderResults = new LinkedList<>();
        binarySearchTree.preOrderPrint(binarySearchTree.getRoot(), preOrderResults);
        System.out.println("先序遍历：" + preOrderResults);

        List<Integer> midOrderResults = new LinkedList<>();
        binarySearchTree.midOrderPrint(binarySearchTree.getRoot(), midOrderResults);
        System.out.println("中序遍历：" + midOrderResults);

        List<Integer> afterOrderResults = new LinkedList<>();
        binarySearchTree.afterOrderPrint(binarySearchTree.getRoot(), afterOrderResults);
        System.out.println("后序遍历：" + afterOrderResults);
    }

    private static class BinarySearchTree<T> {
        private Node<T> root;

        public BinarySearchTree(List<T> values) {
            Node<T> root = new Node<>();
            this.setRoot(root);
            values.forEach(root::addValue);
        }

        public void preOrderPrint(Node<T> node, List<T> results) {
            if (Objects.nonNull(node)) {
                results.add(node.getValue());
                preOrderPrint(node.getLeft(), results);
                preOrderPrint(node.getRight(), results);
            }
        }

        public List<Integer> inOrder(Node<Integer> node) {
            List<Integer> result = new ArrayList<>();
            Stack<Node> treeStack = new Stack<>();

            while(node != null || !treeStack.empty()) {
                if (node != null) {
                    treeStack.add(node);
                    node = node.left;
                } else {
                    result.add(node.getValue());
                    node = node.right;
                }
            }

            return result;
        }

        public void afterOrderPrint(Node<T> node, List<T> results) {
            if (Objects.nonNull(node)) {
                preOrderPrint(node.getLeft(), results);
                preOrderPrint(node.getRight(), results);
                results.add(node.getValue());
            }
        }

        public void midOrderPrint(Node<T> node, List<T> results) {
            if (Objects.nonNull(node)) {
                preOrderPrint(node.getLeft(), results);
                results.add(node.getValue());
                preOrderPrint(node.getRight(), results);
            }
        }
        private static class Node<T> {
            private Node<T> left;
            private Node<T> right;
            private T value;

            public void addValue(T val) {
                if (Objects.isNull(value)) {
                    this.setValue(val);
                    return;
                }

                T rootValue = this.getValue();
                if (String.valueOf(rootValue).compareTo(String.valueOf(val)) < 0) {
                    Node<T> right = this.getRight();
                    if (Objects.isNull(right)) {
                        right = new Node<>();
                        right.setValue(val);
                        this.setRight(right);
                        return;
                    }

                    right.addValue(val);
                } else {
                    Node<T> left = this.getLeft();
                    if (Objects.isNull(left)) {
                        left = new Node<>();
                        left.setValue(val);
                        this.setLeft(left);
                        return;
                    }

                    left.addValue(val);
                }
            }

            public Node<T> getLeft() {
                return left;
            }

            public void setLeft(Node<T> left) {
                this.left = left;
            }

            public Node<T> getRight() {
                return right;
            }

            public void setRight(Node<T> right) {
                this.right = right;
            }

            public T getValue() {
                return value;
            }

            public void setValue(T value) {
                this.value = value;
            }

        }


        public Node<T> getRoot() {
            return root;
        }

        public void setRoot(Node<T> root) {
            this.root = root;
        }
    }

}