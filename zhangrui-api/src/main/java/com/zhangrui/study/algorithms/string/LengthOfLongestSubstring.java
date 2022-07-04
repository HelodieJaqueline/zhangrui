package com.zhangrui.study.algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (null == s) {
            throw new NullPointerException();
        }
        int n = s.length();
        Map<Character, Integer> subStrMap = new HashMap<Character, Integer>();
        for (int j = 0, i = 0; j < n; j++) {
            if (subStrMap.containsKey(s.charAt(j))) {
                i = Math.max(subStrMap.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            subStrMap.put(s.charAt(j), j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstringWithWindow("abcabcbb"));
    }

    public static int lengthOfLongestSubstringWithWindow(String s) {
        int left = 0, right = 0;
        int result = 0;
        Map<Character, Integer> window = new HashMap<Character, Integer>(s.length());
        while (right < s.length()) {
            char r = s.charAt(right);

            right++;
            window.put(r, window.getOrDefault(r, 0) + 1);
            while (window.get(r) > 1) {
                char l = s.charAt(left);
                left++;
                window.put(l, window.getOrDefault(l, 1) - 1);
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

}
