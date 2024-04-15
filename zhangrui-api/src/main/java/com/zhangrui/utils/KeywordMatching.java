package com.zhangrui.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class KeywordMatching {

    private static final Set<String> KEYWORDS = new HashSet<String>();

    static {
        KEYWORDS.add("Weapons");
        KEYWORDS.add("Terrorism");
    }

    public static boolean isKeyword(String word) {
        for (String keyword : KEYWORDS) {
            if (Pattern.compile(keyword, Pattern.CASE_INSENSITIVE).matcher(word).find()) {
                return true;
            }
        }
        return false;
    }


}
