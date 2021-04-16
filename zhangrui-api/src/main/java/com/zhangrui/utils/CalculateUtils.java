package com.zhangrui.utils;

/**
 * @description: 计算器工具
 * @author: ZhangRui
 * @create: 2021-03-04 16:20
 **/


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class CalculateUtils {

    /**
     * 运算符
     */
    private static final String SYMBOL = "+-×÷*/()";

    /**
     * 运算符优先级
     */
    private static final String[] PRIORITY = {"+-", "×÷*/", "()"};

    public static void main(String[] args) throws Exception {
        System.out.println(calculate("3.500×3.3÷(4.5-1.2)+1.5-1.01"));
    }

    /**
     * 运算符比较器
     */
    static Comparator<String> comp = (s1, s2) -> {
        int n1 = 0, n2 = 0;
        for (int i = 0; i < PRIORITY.length; i++) {
            if (PRIORITY[i].contains(s1)) {
                n1 = i;
            }
            if (PRIORITY[i].contains(s2)) {
                n2 = i;
            }
        }
        return (n1 - n2);
    };

    // double 小数点处理
    public double getResultByDouble(double doublevale, int len) {
        if (len == 0) {
            len = 2;
        }
        BigDecimal b = new BigDecimal(doublevale);
        return b.setScale(len, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    /**
     * 输入字符串公式，返回结果
     *
     * @param exp
     * @return
     * @throws Exception
     */
    public static double calculate(String exp) throws Exception {
        // 中缀转后缀
        List<String> list = analyze(exp);
        // 计算结果
        double result = calculate(list);
        String string = String.format("%.2f", result);
        // String.format("%.2f", result);//%.2f\n解释：%f ——浮点型 .2 ——两位小数点 \n ——换行
        return Double.parseDouble(string);
    }

    /**
     * 输入字符串公式，返回结果
     *
     * @param exp
     * @return
     * @throws Exception
     */
    public static double getResultByString(String exp) throws Exception {
        String string = String.format("%.2f", exp);
        // String.format("%.2f", result);//%.2f\n解释：%f ——浮点型 .2 ——两位小数点 \n ——换行
        return Double.parseDouble(string);
    }

    /**
     * 分析算式
     *
     * @param exp
     * @return
     * @throws Exception
     */
    public static List<String> analyze(String exp) throws Exception {
        if (exp == null) {
            throw new Exception("illegal parameter.");
        }
        exp = exp.replaceAll("\\s*", ""); // 去掉所有的空格（为了方便中间存在空格算合法）
        List<String> list = new ArrayList<String>();
        Stack<String> sym = new Stack<String>();
        StringBuilder buf = new StringBuilder();
        for (char c : exp.toCharArray()) {
            if (SYMBOL.indexOf(c) >= 0) { // 如果是运算符
                if (buf.length() > 0) { // 如果有操作数
                    String v = buf.toString();
                    if (!v.matches("\\d+([.]\\d+)?")) {
                        throw new Exception("illegal varaible(" + v + ").");
                    }
                    list.add(v);
                    buf.delete(0, buf.length());
                }

                if (c == '(') {
                    sym.push(String.valueOf(c));
                } else if (c == ')') {
                    String last = "";
                    while (sym.size() > 0) {
                        last = sym.pop();
                        if ("(".equals(last)) {
                            break;
                        } else {
                            list.add(last);
                        }
                    }
                    if (!"(".equals(last)) {
                        throw new Exception("illigal express.");
                    }
                } else if (sym.size() > 0) {
                    String s = String.valueOf(c);
                    String last = sym.peek();
                    if ("(".equals(last) || comp.compare(s, last) > 0) {
                        sym.push(s);
                    } else {
                        last = sym.pop();
                        list.add(last);
                        sym.push(s);
                    }
                } else {
                    sym.push(String.valueOf(c));
                }
            } else { // 不是运算符则当作操作数（因为已经去除所有空格，这里不再需要判断空格）
                buf.append(c);
            }
        }

        if (buf.length() > 0) {
            list.add(buf.toString());
        }

        while (sym.size() > 0) {
            String last = sym.pop();
            if ("()".contains(last)) {
                throw new Exception("illigal express.");
            }
            list.add(last);
        }

        return list;
    }

    /**
     * 计算
     *
     * @param list
     * @return
     * @throws Exception
     */
    public static double calculate(List<String> list) throws Exception {
        Stack<Double> val = new Stack<Double>();
        double result = 0;

        while (list.size() > 0) {
            String s = list.remove(0);
            if (SYMBOL.contains(s)) {
                double d1 = val.pop();
                double d2 = val.pop();
                if ("+".equals(s)) {
                    result = d2 + d1;
                } else if ("-".equals(s)) {
                    result = d2 - d1;
                } else if ("*".equals(s) || "×".equals(s)) {
                    result = d2 * d1;
                } else if ("/".equals(s) || "÷".equals(s)) {
                    result = d2 / d1;
                } else {
                    throw new Exception("illigal symbol(" + s + ").");
                }
                val.push(result);
            } else {
                if (!s.matches("\\d+([.]\\d+)?")) {
                    throw new Exception("illigal variable(" + s + ").");
                }
                val.push(Double.valueOf(s));
            }
        }
        return result;
    }
}


