package com.zhangrui.study.algorithms.array;

/**
 * @description:
 * @author: rui.zhang
 * @create: 2022-03-13 21:19
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            ConvertArray.convertArray(row);
        }
    }
}