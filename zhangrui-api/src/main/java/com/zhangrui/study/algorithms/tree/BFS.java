package com.zhangrui.study.algorithms.tree;

import com.zhangrui.study.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: rui.zhang
 * @date: 2022-08-10 23:34
 * 二叉树的广度优先遍历
 */
public class BFS {

    public static void bfs(TreeNode root) {

        if (null == root) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            traverse(node);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    public static void traverse(TreeNode node) {
        System.out.println(node.val);
    }

}