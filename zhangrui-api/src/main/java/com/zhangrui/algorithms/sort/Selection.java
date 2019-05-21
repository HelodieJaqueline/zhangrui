package com.zhangrui.algorithms.sort;

/**
 * 从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
 * 选择排序需要 ~N2/2 次比较和 ~N 次交换，它的运行时间与输入无关，这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
 * @param <T>
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        // N-1趟是因为最后一趟是nums[N-2](倒数第二个元素) 和nums[N-1](最后一个元素)比较
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            // 每次都从剩余的数中的第一个数nums[i]和第二个数nums[i+1]开始比较,选出小的，并将下标赋给min
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            //交换当前的数和这一趟最小的数
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {128,0,1,1000,-5};
        System.out.print("排序前: ");
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        Sort<Integer> sort = new Selection<Integer>();
        sort.sort(nums);
        System.out.print("排序后: ");
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
