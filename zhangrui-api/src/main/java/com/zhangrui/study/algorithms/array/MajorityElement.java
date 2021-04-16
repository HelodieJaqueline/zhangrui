package com.zhangrui.study.algorithms.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-07-25-13:02
 * @Description: Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * @Modified: By
 */
public class MajorityElement {

	public static int majorityElement(int[] nums) {
		if (null == nums || nums.length < 1) {
			throw new NullPointerException("The array is NULL!");
		}
		int length = nums.length;
		Integer zero = 0;
		Map<Integer, Integer> elements = new HashMap<>();
		for (int num : nums) {
			Integer count = elements.get(num);
			if (null == count || zero.equals(count)) {
				elements.put(num, 1);
				if (1 == length) {
					return num;
				}
			}else {
				elements.put(num, count + 1);
				if (elements.get(num) > (length / 2)) {
					return num;
				}
			}
		}
		throw new IllegalArgumentException("The array is illegal!");
	}

	public static int majorityElementAdvanced(int[] nums) {
		if (null == nums || nums.length < 1) {
			throw new NullPointerException("The array is NULL!");
		}
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{1,2,1,2,2,0,0,0,0,0,0}));
		System.out.println(majorityElementAdvanced(new int[]{1,2,1,2,2,0,0,0,0,0,0}));
	}
}
