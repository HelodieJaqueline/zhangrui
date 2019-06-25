package com.zhangrui.algorithms.sort;

/**
 * @Author: YSTen
 * @Date: Created at 2019-05-28-13:09
 * @Description:
 * @Modified: By
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	public void sort(T[] nums) {
		Integer N = nums.length;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N - 1 - i; j++) {
				if (less(nums[j], nums[i])) {
					swap(nums, j, i);
				}
			}
		}
	}
	public static void main(String[] args) {
		Integer[] nums = {128,0,1,-5,1000};
		System.out.print("排序前: ");
		for (Integer num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
		Sort<Integer> sort = new BubbleSort<Integer>();
		sort.sort(nums);
		System.out.print("排序后: ");
		for (Integer num : nums) {
			System.out.print(num + " ");
		}
	}
}
