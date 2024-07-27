package com.zhangrui.study.algorithms.search;

public class BinarySearch {


    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return  -1;
        }
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid +1;
            }
        }
        return -1;
    }

/*    public void binarySearch() {
        int binarySearch(int[] nums, int target) {
            int left = 0, right = ...;

            while(...) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
            ...
                } else if (nums[mid] < target) {
                    left = ...
                } else if (nums[mid] > target) {
                    right = ...
                }
            }
            return ...;
        }
    }*/
}
