package com.zhangrui.study.algorithms.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RansomNode {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }
        if (ransomNote.length() < 1 || magazine.length() < 1) {
            return false;
        }
        List<Character> magazineList = new ArrayList<Character>(magazine.length());
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magazineList.add(c);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (magazineList.contains(c)) {
                magazineList.remove(magazineList.indexOf(c));
            } else {
                return false;
            }
        }
        return true;
    }

}