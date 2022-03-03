package com.zhangrui.study.algorithms.tree;

import com.zhangrui.study.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 前序遍历
 * @author: rui.zhang
 * @create: 2022-03-03 23:06
 */
public class PreorderTraversal {

    private List<Integer> res = new LinkedList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    public void traversal(TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }

}