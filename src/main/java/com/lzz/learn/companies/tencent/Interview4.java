package com.lzz.learn.companies.tencent;

/**
 * @author LimLee
 * @data 2020-08-23
 **/
import java.util.ArrayList;
import java.util.Scanner;

public class Interview4 {
    public static void main(String[] args) {
//        ListNode head = deleteK();
        process();
    }
    private static ListNode deleteK() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = in.nextInt();
        }
        for (int j = 0; j < n; j ++) {
            if (j == k - 1) continue;
            System.out.print(nums[j] + " ");
        }
        ListNode head = new ListNode();

        if (k == 1) {
            if (n > 1) {
                head.next = new ListNode(nums[1]);
            }
        } else {
            head.next = new ListNode(nums[0]);
        }
        return head;
    }

    public static void process() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt() - 1;
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            nums.add(in.nextInt());
        }
        nums.remove(k );
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
