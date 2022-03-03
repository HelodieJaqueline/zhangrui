package com.zhangrui.study.algorithms.tree;

import com.zhangrui.study.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 后序遍历
 * @author: rui.zhang
 * @create: 2022-03-03 23:07
 */
public class PostorderTraversal {

    List<Integer> res = new LinkedList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }

}