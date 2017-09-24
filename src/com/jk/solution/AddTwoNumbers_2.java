package com.jk.solution;

public class AddTwoNumbers_2 {

    public static void test() {
        System.out.println("2 Add Two Numbers:");

        ListNode l1 = new ListNode(2);
        ListNode n1 = l1;
        n1.next = new ListNode(4);
        n1 = n1.next;
        n1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode n2 = l2;
        n2.next = new ListNode(6);
        n2 = n2.next;
        n2.next = new ListNode(4);
        n2 = n2.next;
        n2.next = new ListNode(9);

        ListNode ret = addTwoNumbers(l1, l2);
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // recursive
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        return addTwoNumbers(l1, l2, 0);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null) {
            return (add == 0) ? null : new ListNode(add);
        }

        ListNode sum = new ListNode(0);
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;
        int val = val1 + val2 + add;
        sum.val = val % 10;

        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
        sum.next = addTwoNumbers(l1, l2, val / 10);

        return sum;
    }

    // regular
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode sum = new ListNode(0);
        ListNode tail = sum;
        boolean carry = false;
        while (l1 != null || l2 != null) {
            tail.next = new ListNode(0);
            tail = tail.next;

            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + (carry ? 1 : 0);
            carry = val >= 10;
            tail.val = carry ? val - 10 : val;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry) {
            tail.next = new ListNode(1);
        }

        return sum.next;
    }


}
