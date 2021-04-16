package com.zhangrui.study.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-08-29-16:08
 * @Description: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle. In Pascal's
 * triangle, each number is the sum of the two numbers directly above it.
 * @https://leetcode.com/problems/pascals-triangle/
 * @Modified: By
 */
public class PascalTriangle {


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>(numRows);
        if (numRows < 1) {
            return resultList;
        }
        for (int i = 1; i <= numRows; i++) {
            List<Integer> rowList = new ArrayList<>(i);
            if (1 == i) {
                rowList.add(1);
            } else if (2 == i) {
                rowList.add(1);
                rowList.add(1);
            } else {
                List<Integer> headRowList = resultList.get(i - 2);
                rowList.add(1);
                for (int j = 1; j < headRowList.size(); j++) {
                    rowList.add(headRowList.get(j) + headRowList.get(j - 1));
                }
                rowList.add(1);
            }

            resultList.add(rowList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }
}
