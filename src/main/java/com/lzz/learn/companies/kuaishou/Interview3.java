package com.lzz.learn.companies.kuaishou;

import java.util.Stack;

/**
 * @author LimLee
 * @data 2020-09-02
 * 
 **/
public class Interview3 {
    public static void main(String[] args) {
        System.out.println(removeBC("abcbcbbcbccbcd"));
    }

    public static String removeBC(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        if (n < 2) return s;
        for (int i = 0; i < n; i ++) {
            if (stk.isEmpty()) {
                stk.push(s.charAt(i));
            } else {
                if (s.charAt(i) == 'c' && stk.peek() == 'b') {
                    stk.pop();
                } else {
                    stk.push(s.charAt(i));
                }
            }
        }
        StringBuilder ss = new StringBuilder();
        while (!stk.isEmpty()) {
            ss.append(stk.pop());
        }
        return ss.reverse().toString();
    }
}
