package indi.latch.algorithm.interview;

import java.util.*;
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
        //TreeNode root = interviewDemo.buildBinaryTree(list);

        TreeNode treeNode = interviewDemo.buildTestCase();
        System.out.println(interviewDemo.levelTraverse(treeNode));
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

    private List<Integer> levelTraverse(TreeNode node) {
        if (Objects.isNull(node)) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> treeQueue = new ArrayDeque<>();
        treeQueue.add(node);
        while(!treeQueue.isEmpty()) {
            TreeNode pollNode = treeQueue.poll();
            result.add(pollNode.getVal());

            if (Objects.nonNull(pollNode.getLeft())) {
                treeQueue.add(pollNode.getLeft());
            }

            if (Objects.nonNull(pollNode.getRight())) {
                treeQueue.add(pollNode.getRight());
            }
        }

        return result;
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