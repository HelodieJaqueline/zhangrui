package com.zhangrui.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZhangRui
 * @create: 2020-08-25 13:10
 **/
public class KidsWithTheGreatestNumberOfCandies {


    public static void main(String[] args) {
        kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (null == candies || extraCandies < 0) {
            return null;
        }
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            if ((candies[i] + extraCandies) >= max) {
                result.add(true);
            }else {
                result.add(false);
            }
        }
        return result;
    }
}
