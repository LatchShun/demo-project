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

        System.out.println("2023-02-23：");
        TreeNode root1 = treeTraverseDemo.buildTreeNode(numbers, 0);
        System.out.println("先序遍历：" + treeTraverseDemo.preTraverse(root1));
        System.out.println("中序遍历：" + treeTraverseDemo.midTraverse(root1));
        System.out.println("后序遍历：" + treeTraverseDemo.postTraverse(root1));
        System.out.println("层序遍历：" + treeTraverseDemo.levelTraverse(root1));

        System.out.println("2023-02-24：");
        TreeNode root2 = treeTraverseDemo.buildTreeNodeV2(numbers, 0);
        System.out.println("先序遍历：" + treeTraverseDemo.preTraverseV2(root2));
        System.out.println("中序遍历：" + treeTraverseDemo.midTraverseV2(root2));
        System.out.println("后序遍历：" + treeTraverseDemo.postTraverseV2(root2));
        System.out.println("层序遍历：" + treeTraverseDemo.levelTraverseV2(root2));
    }

    private List<Integer> levelTraverseV2(TreeNode node) {
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

    private List<Integer> postTraverseV2(TreeNode node) {
        return Collections.emptyList();
    }

    private List<Integer> midTraverseV2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty() || Objects.nonNull(node)) {
            while (Objects.nonNull(node)) {
                stack.add(node);
                node = node.getLeft();
            }

            TreeNode popNode = stack.pop();
            result.add(popNode.getVal());

            if (Objects.nonNull(popNode.getRight())) {
                node = popNode.getRight();
            }
        }

        return result;
    }

    private TreeNode buildTreeNodeV2(List<Integer> numbers, int start) {
        if (numbers == null || numbers.size() == 0 || start >= numbers.size()) {
            return null;
        }

        TreeNode root = new TreeNode(numbers.get(start));
        root.setLeft(buildTreeNodeV2(numbers, 2 * start + 1));
        root.setRight(buildTreeNodeV2(numbers, 2 * start + 2));
        return root;
    }

    private List<Integer> preTraverseV2(TreeNode node) {
        Stack<TreeNode> queue = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty() || Objects.nonNull(node)) {
            while (Objects.nonNull(node)) {
                result.add(node.getVal());
                queue.add(node);
                node = node.getLeft();
            }

            TreeNode popNode = queue.pop();
            node = popNode.getRight();
        }
        return result;
    }

    private TreeNode buildTreeNode(List<Integer> numbers, int start) {
        if (Objects.isNull(numbers) || numbers.size() == 0 || start > (numbers.size() - 1)) {
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
     * 1
     * 2               3
     * 4       5       6       7
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
        List<Integer> result = new ArrayList<>();

        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (Objects.nonNull(node) || !stack.isEmpty()) {
            while (Objects.nonNull(node)) {
                stack.add(node);
                node = node.getLeft();
            }

            TreeNode popNode = stack.pop();
            if (Objects.nonNull(popNode.getRight())) {
                stack.add(popNode);
                node = popNode.getRight();
            } else {
                result.add(popNode.getVal());
            }
        }
        return result;
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