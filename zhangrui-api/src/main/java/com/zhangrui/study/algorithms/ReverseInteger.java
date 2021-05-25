package com.zhangrui.study.algorithms;

//Given a signed 32-bit integer x, return x with its digits reversed. If reversi
//ng x causes the value to go outside the signed 32-bit integer range [-231, 231 -
// 1], then return 0.
//
// Assume the environment does not allow you to store 64-bit integers (signed or
// unsigned).
//
//
// Example 1:
// Input: x = 123
//Output: 321
// Example 2:
// Input: x = -123
//Output: -321
// Example 3:
// Input: x = 120
//Output: 21
// Example 4:
// Input: x = 0
//Output: 0
//
//
// Constraints:
//
//
// -231 <= x <= 231 - 1
//
// Related Topics Math
// 👍 4750 👎 7240


/**
 * @description:
 * @author: ZhangRui
 * @create: 2021-05-18 17:03
 **/
public class ReverseInteger {

    public static void main(String[] args) {
        int reverse = new ReverseInteger().reverse(-2147483648);
        System.out.println(reverse);
    }


    public int reverse(int x) {
        boolean blewZero = false;
        if (x < 0) {
            blewZero = true;
            x = Math.abs(x);
        }
        String str = String.valueOf(x);
        int length = str.length();
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = str.charAt(length-1 - i);
        }
        String s = new String(result);
        if (blewZero) {
            s = "-".concat(s);
        }
        Long value = Long.valueOf(s);
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return 0;
        }
        return value.intValue();
    }
}
