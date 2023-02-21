package indi.latch.algorithm.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Title: InterviewDemo
 * Description:
 * Copyright:
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class InterviewDemo {

    public static void main(String[] args) {
        InterviewDemo interviewDemo = new InterviewDemo();
        List<Integer> list = IntStream.range(1, 8).boxed().collect(Collectors.toList());
        TreeNode root = interviewDemo.buildBinaryTree(list);

        TreeNode treeNode = interviewDemo.buildTestCase();
        System.out.println(interviewDemo.process(treeNode));
    }

    private TreeNode buildTestCase() {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        return new TreeNode(1, node2, node3);
    }

    private TreeNode buildBinaryTree(List<Integer> list) {
        List<TreeNode> nodes = new ArrayList<>(list.size());
        for (Integer val : list) {
            nodes.add(new TreeNode(val, null, null));
        }

        for (int i = 0; i < nodes.size(); i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < nodes.size()) {
                nodes.get(i).setLeft(nodes.get(left));
            }

            if (right < nodes.size()) {
                nodes.get(i).setRight(nodes.get(right));
            }
        }

        return nodes.get(0);
    }

    private List<Integer> process(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<TreeNode> treeNodeList = buildTreeNodes(node);
        return treeNodeList.stream().map(treeNode -> treeNode.getVal()).collect(Collectors.toList());
    }

    private List<TreeNode> buildTreeNodes(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(node);
        while (node.getLeft() != null || node.getRight() != null) {
            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }

        }

        return nodes;
    }

    public static class TreeNode {
        private int val;

        private TreeNode left;

        private TreeNode right;

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
