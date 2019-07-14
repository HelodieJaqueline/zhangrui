package com.zhangrui.algorithms;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        if (n < 1) {
            return null;
        }
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";
        List<String> fizzBuzzList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i < 15) {
                if (i % 3 == 0) {
                    fizzBuzzList.add(fizz);
                } else if (i % 5 == 0) {
                    fizzBuzzList.add(buzz);
                }else {
                    fizzBuzzList.add(String.valueOf(i));
                }
            }else {
                if (i % 3 == 0) {
                    if (i % 5 == 0) {
                        fizzBuzzList.add(fizzBuzz);
                    }else {
                        fizzBuzzList.add(fizz);
                    }
                } else if (i % 5 == 0) {
                    fizzBuzzList.add(buzz);
                }else {
                    fizzBuzzList.add(String.valueOf(i));
                }
            }
        }
        return fizzBuzzList;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15).toString());
    }
}
