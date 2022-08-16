package com.zhangrui.study.algorithms.array;

/**
 * @author: rui.zhang
 * @date: 2022-08-16 22:52
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int left = 0 , right = height.length -1;
        int res = 0;
        while(left <right){
            int area = (right - left) * Math.min(height[left],height[right]);
            res = Math.max(area,res);

            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}