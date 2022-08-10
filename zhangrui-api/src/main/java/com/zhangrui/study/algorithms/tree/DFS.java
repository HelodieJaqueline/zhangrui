package com.zhangrui.study.algorithms.tree;

import cn.hutool.core.lang.tree.Tree;
import com.zhangrui.study.algorithms.TreeNode;

import java.util.Stack;

/**
 * @author: rui.zhang
 * @date: 2022-08-10 22:57
 * 二叉树的深度优先遍历
 */
public class DFS {

    public static void main(String[] args) {

    }

    /**
     * 递归遍历
     * @param root
     */
    public static void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        //遍历节点
        traverse(root);

        //左节点
        recursion(root.left);

        //右节点
        recursion(root.right);
    }

    /**
     * 非递归遍历
     * 使用栈:先遍历当前节点，然后把右节点压栈，再压左节点
     * @param root
     */
    public static void withOutRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            traverse(node);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(root.left);
            }
        }
    }


    public static void traverse(TreeNode node) {
        System.out.println(node.val);
    }
}