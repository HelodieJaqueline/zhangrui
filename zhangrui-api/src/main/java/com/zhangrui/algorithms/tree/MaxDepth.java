package com.zhangrui.algorithms.tree;

import com.zhangrui.algorithms.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
    }
}
