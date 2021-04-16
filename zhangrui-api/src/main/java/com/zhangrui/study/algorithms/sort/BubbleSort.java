package com.zhangrui.study.algorithms.sort;

/**
 * @Author: YSTen
 * @Date: Created at 2019-05-28-13:09
 * @Description:
 * @Modified: By
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
 * @param <T>
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
