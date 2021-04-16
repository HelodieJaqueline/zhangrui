package com.zhangrui.study.algorithms.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: Given the root node of a binary search tree,
 * return the sum of values of all nodes with value between L and R (inclusive).
 * The binary search tree is guaranteed to have unique values.
 * @author: ZhangRui
 * @create: 2020-09-20 21:52
 **/
public class RangeSumBST {

    public static void main(String[] args) {
        //System.out.println(rangeSumBST());
    }


    public static int rangeSumBST(TreeNode root, int l, int r) {
        int ans = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (l <= node.val && node.val <= r) {
                ans += node.val;
            }
            if (l < node.val) {
                stack.push(node.left);
            }
            if (node.val < r) {
                stack.push(node.right);
            }
        }
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
