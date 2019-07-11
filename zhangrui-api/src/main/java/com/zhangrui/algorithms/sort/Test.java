package com.zhangrui.algorithms.sort;

public class Test {
    public static void main(String[] args) {
        Integer[] nums = {128,0,1,1000,-5};
        System.out.print("排序前: ");
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
/*        Sort<Integer> sort = new Selection<>();
        Sort<Integer> sort = new BubbleSort<>();*/
        Sort<Integer> sort = new Insertion<>();
        sort.sort(nums);
        System.out.print("排序后: ");
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
