package com.lzz.learn.companies.dianxinyun;

/**
 * @author LimLee
 * @data 2020-09-16
 **/
import java.util.*;

public class Interview3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.nextLine();
        MinStack minStack = new MinStack();
        for (int i = 0; i < n; i ++) {
            String curS = in.nextLine();
            String[] words = curS.split(" ");
            String op = words[0];
            switch (op) {
                case "push":
                    minStack.push(Integer.valueOf(words[1]));
                    break;
                case "pop":
                    minStack.pop();
                    break;
                case "top":
                    System.out.println(minStack.top());
                    break;
                case "getMin":
                    System.out.println(minStack.getMin());
                    break;
                default:
                    break;
            }
        }
    }
}

class MinStack {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public MinStack() {
        stk1 = new Stack();
        stk2 = new Stack();
    }
    public void push(int x) {
        stk1.push(x);
        if (stk2.isEmpty()) {
            stk2.push(x);
        } else {
            if (stk2.peek() >= x) {
                stk2.push(x);
            }
        }
    }

    public void pop() {
        int ans = stk1.pop();
        while (!stk2.isEmpty() && ans == stk2.peek()) {
            stk2.pop();
        }
    }

    public int top() {
        return stk1.peek();
    }

    public int getMin() {
        return stk2.peek();
    }
}