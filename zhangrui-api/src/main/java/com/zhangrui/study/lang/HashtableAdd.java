package com.zhangrui.study.lang;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableAdd {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        StringBuffer sb = new StringBuffer();
        sb.append("abc,");
        ht.put("1", sb);
        sb.append("def,");
        ht.put("2", sb);
        sb.append("mno,");
        ht.put("3", sb);
        sb.append("xyz.");
        ht.put("4", sb);
 
        int numObj = 0;
        Enumeration it = ht.elements();
        while (it.hasMoreElements()) {
            System.out.print("get StringBufffer " + (++numObj) + " from Hashtable: ");
            System.out.println(it.nextElement());
        }
    }
}