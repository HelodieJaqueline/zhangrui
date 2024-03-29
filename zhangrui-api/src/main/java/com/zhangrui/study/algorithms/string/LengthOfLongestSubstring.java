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
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

}
