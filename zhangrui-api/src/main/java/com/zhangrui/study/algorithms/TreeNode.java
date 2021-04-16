package com.zhangrui.study.algorithms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
