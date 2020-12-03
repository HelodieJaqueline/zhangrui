package com.zhangrui.algorithms.string;

/**
 * @description:
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 * Example 1:
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 * @author: ZhangRui
 * @create: 2020-09-14 09:47
 **/
public class BalancedStringSplit {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        int cnt = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == 'L') {
                cnt--;
            } else {
                cnt++;
            }
            if (cnt == 0) {
                ans++;
            }
        }
        return ans;
    }
}
