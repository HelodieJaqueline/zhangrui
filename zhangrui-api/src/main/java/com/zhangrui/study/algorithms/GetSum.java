package com.zhangrui.study.algorithms;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-08-01-16:30
 * @Description: Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * @Modified: By
 */
public class GetSum {


	public static int getSum(int a, int b) {
/*		// If b or carry is 0, then return the number.
		if (b == 0) {
			return a;
		}

		// Else get sum of a xor b that gives a + b (without the carry)
		// And add carry to it, carry is just a AND b, left shifted by 1
		return getSum(a ^ b, (a & b) << 1);*/
		return 0 == b ? a : getSum(a ^ b, (a & b) << 1);
	}

	public static void main(String[] args) {
		System.out.println(getSum(1,1));
	}
}
