package com.zhangrui.study.algorithms;

/**
 * 二叉树最大深度
 */
public class MaxDepth1 {

    // 记录最大深度
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历框架
    void traverse(TreeNode root) {
        if (root == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
            return;
        }
        // 前序位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }

}
