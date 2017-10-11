package com.jk.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedLists_23 {

    public static void test() {
        System.out.println("2 MergeSortedLists:");

        ListNode l1 = new ListNode(0);
        ListNode t1 = l1;
        t1.next = new ListNode(2);
        t1 = t1.next;
        t1.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        ListNode t2 = l2;
        t2.next = new ListNode(3);
        t2 = t2.next;
        t2.next = new ListNode(5);

        ListNode l3 = new ListNode(7);
        ListNode t3 = l3;
        t3.next = new ListNode(8);
        t3 = t3.next;
        t3.next = new ListNode(9);

        ListNode l4 = new ListNode(11);
        ListNode t4 = l4;
        t4.next = new ListNode(12);
        t4 = t4.next;
        t4.next = new ListNode(13);


        ListNode[] lists = new ListNode[]{l3, l2, l1, l4};

        ListNode ret = mergeKLists(lists);
        printNode(ret);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void printNodeList(ListNode[] lists) {
        System.out.println("---- list -----");
        for (ListNode node : lists) {
            printNode(node);
        }
    }

    private static void printNode(ListNode node) {
        StringBuilder sb = new StringBuilder("node = ");
        while (node != null) {
            sb.append(node.val);
            sb.append(", ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null) {
                pq.add(tail.next);
            }
        }

        return head.next;
    }


    //////// merge list one by one /////////////

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // ListNode head = mergeKLists(lists, 0, lists.length - 1);
        ListNode head = mergeKLists(lists, lists.length - 1);
        System.out.println("count2:" + count2);
        return head;
    }

    private static ListNode mergeKLists(ListNode[] lists, int end) {
        if (end == 0) {
            return lists[0];
        }

        int next = 0;
        for (int i = 0; ; i++) {
            if (i == end - i) {
                next = i;
                break;
            } else if (i > end - i) {
                next = i - 1;
                break;
            }

            lists[i] = mergeTwoLists(lists[i], lists[end - i]);
        }

        return mergeKLists(lists, next);
    }

    private static ListNode mergeKLists(ListNode[] lists, int s, int e) {
        if (s > e) {
            return null;
        }
        if (s == e) {
            return lists[s];
        }

        int mid = (e + s) / 2;
        System.out.println("s:" + s);
        System.out.println("e:" + e);
        System.out.println("mid:" + mid);
        System.out.println("(" + s + "," + mid + ")");
        ListNode l1 = mergeKLists(lists, s, mid);
        System.out.println("(" + String.valueOf(mid + 1) + "," + e + ")");
        ListNode l2 = mergeKLists(lists, mid + 1, e);
        return mergeTwoLists(l1, l2);
    }

    static int count2 = 0;

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        count2++;
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


    //////// Brute Force  /////////////

    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode(Integer.MAX_VALUE);
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                if (node.val < head.val) {
                    minIndex = i;
                    head = node;
                }
            }
        }

        if (minIndex == -1) {
            return null;
        }

        if (lists[minIndex].next == null) {
            ListNode[] dest = new ListNode[lists.length - 1];
            System.arraycopy(lists, 0, dest, 0, minIndex);
            System.arraycopy(lists, minIndex + 1, dest, minIndex, lists.length - minIndex - 1);
            lists = dest;
        } else {
            lists[minIndex] = lists[minIndex].next;
        }

        head.next = mergeKLists(lists);
        return head;
    }
}
