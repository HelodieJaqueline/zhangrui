package com.zhangrui.study.algorithms.tree;

import com.zhangrui.study.algorithms.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }

        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());

        return Math.max(leftDepth, rightDepth) + 1;
    }

    int res = 0;

    int depth = 0;

    public int maxDepth2(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            res = Math.max(res, depth);
            return;
        }
        depth++;
        traverse(root.getLeft());
        traverse(root.getRight());
        depth--;
    }
}
