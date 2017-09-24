package com.jk.solution;

public class MergeSortedLists_21 {

    public static void test() {
        System.out.println("21 Merge Two Sorted Lists:");

        ListNode l1 = new ListNode(1);
        ListNode n1 = l1;
        n1.next = new ListNode(4);
        n1 = n1.next;
        n1.next = new ListNode(6);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);

        ListNode ret = mergeTwoLists(l1, l2);
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
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
    }

    // regular copy
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode newList = new ListNode(0);
        ListNode tail = newList;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tail.val = l2.val;
                tail.next = l2.next;
                break;
            }
            if (l2 == null) {
                tail.val = l1.val;
                tail.next = l1.next;
                break;
            }


            if (l1.val < l2.val) {
                tail.val = l1.val;
                l1 = l1.next;
            } else {
                tail.val = l2.val;
                l2 = l2.next;
            }

            tail.next = new ListNode(0);
            tail = tail.next;
        }

        return newList;
    }

    // regular link
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode newList = new ListNode(0);
        ListNode tail = newList;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tail.next = l2;
                break;
            }
            if (l2 == null) {
                tail.next = l1;
                break;
            }


            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        return newList.next;
    }

}
