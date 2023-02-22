package indi.latch.algorithm.tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Title: TreeTraverseDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/22
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class TreeTraverseDemo {

    public static void main(String[] args) {
        TreeTraverseDemo treeTraverseDemo = new TreeTraverseDemo();

        List<Integer> numbers = IntStream.range(1, 8).boxed().collect(Collectors.toList());
        TreeNode root = treeTraverseDemo.buildTreeNode(numbers, 0);

        System.out.println("先序遍历：" + treeTraverseDemo.preTraverse(root));
        System.out.println("中序遍历：" + treeTraverseDemo.midTraverse(root));
        System.out.println("后序遍历：" + treeTraverseDemo.postTraverse(root));
        System.out.println("层序遍历：" + treeTraverseDemo.levelTraverse(root));
    }

    private TreeNode buildTreeNode(List<Integer> numbers) {
        if (numbers.size() == 0 || Objects.isNull(numbers)) {
            return null;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            TreeNode node = new TreeNode(numbers.get(i));
            nodeList.add(node);
        }

        for (int i = 0; i < nodeList.size(); i++) {
            if ((2 * i + 1) < (nodeList.size() - 1)) {
                nodeList.get(i).setLeft(nodeList.get(2 * i + 1));
            }
            if ((2 * i + 2) < (nodeList.size() - 1)) {
                nodeList.get(i).setRight(nodeList.get(2 * i + 2));
            }
        }

        return nodeList.get(0);
    }

    private TreeNode buildTreeNode(List<Integer> numbers, int start) {
        if (Objects.isNull(numbers) || numbers.size() == 0  || start > (numbers.size() - 1)) {
            return null;
        }

        TreeNode node = new TreeNode(numbers.get(start));
        if ((2 * start + 1) < numbers.size()) {
            node.setLeft(buildTreeNode(numbers, 2 * start + 1));
        }

        if ((2 * start + 2) < numbers.size()) {
            node.setRight(buildTreeNode(numbers, 2 * start + 2));
        }

        return node;
    }

    /**
     *
                    1
            2               3
        4       5       6       7
     */
    private List<Integer> preTraverse(TreeNode node) {
        if (Objects.isNull(node)) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            result.add(popNode.getVal());

            if (Objects.nonNull(popNode.getRight())) {
                stack.add(popNode.getRight());
            }

            if (Objects.nonNull(popNode.getLeft())) {
                stack.add(popNode.getLeft());
            }
        }
        return result;
    }

    private List<Integer> midTraverse(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (Objects.nonNull(node) || !stack.isEmpty()) {
            if (Objects.nonNull(node)) {
                stack.add(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                result.add(node.getVal());
                node = node.getRight();
            }
        }

        return result;
    }

    private List<Integer> postTraverse(TreeNode node) {
        return Collections.emptyList();
    }

    private List<Integer> levelTraverse(TreeNode node) {
        if (Objects.isNull(node)) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode pollNode = queue.poll();
            result.add(pollNode.getVal());

            if (Objects.nonNull(pollNode.getLeft())) {
                queue.add(pollNode.getLeft());
            }

            if (Objects.nonNull(pollNode.getRight())) {
                queue.add(pollNode.getRight());
            }
        }
        return result;
    }

    public static class TreeNode {
        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

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