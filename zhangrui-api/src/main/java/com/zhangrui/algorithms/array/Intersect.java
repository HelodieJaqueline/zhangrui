package com.zhangrui.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>(nums1.length);
        List<Integer> list2 = new ArrayList<>(nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list2.add(nums2[i]);
        }
        List<Integer> result = null;
        if (list1.size() < list2.size()) {
            list2.retainAll(list1);
            result = list2;
        }else {
            list1.retainAll(list2);
            result = list1;
        }
        int[] intersect = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersect[i] = result.get(i);
        }
        return intersect;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] result = new Intersect().intersect(nums1, nums2);
    }
}
