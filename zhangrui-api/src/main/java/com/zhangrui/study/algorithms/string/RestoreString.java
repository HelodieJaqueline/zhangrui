package com.zhangrui.study.algorithms.string;

/**
 * @description:
 * Given a string s and an integer array indices of the same length.
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 * Return the shuffled string.
 * @author: ZhangRui
 * @create: 2020-08-30 14:28
 **/
public class RestoreString {

    public static void main(String[] args) {
        System.out.println(restoreString("aiohn", new int[]{3, 1, 4, 2, 0}));
    }

    public static String restoreString(String s, int[] indices) {
/*        if (null == s || null == indices || s.length() != indices.length) {
            return null;
        }
        Map<Integer, Character> treeMap = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            treeMap.put(indices[i], s.charAt(i));
        }
        char[] newChar = new char[indices.length];
        int index = 0;
        for (Character value : treeMap.values()) {
            newChar[index] = value;
            index++;
        }
        return new String(newChar);*/
        char[] c = new char[s.length()];
        for(int i=0;i<indices.length;i++){
            c[indices[i]]=s.charAt(i);
        }
        return String.valueOf(c);
    }
}
