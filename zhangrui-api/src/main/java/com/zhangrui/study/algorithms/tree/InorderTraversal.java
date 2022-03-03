package com.zhangrui.study.algorithms.tree;

import com.zhangrui.study.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 中序遍历
 * @author: rui.zhang
 * @create: 2022-03-03 23:05
 */
public class InorderTraversal {

    private List<Integer> res = new LinkedList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    public void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);
        res.add(root.val);
        traversal(root.right);
    }

}