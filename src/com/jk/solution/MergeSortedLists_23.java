package com.jk.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedLists_23 {

    public static void test() {
        System.out.println("2 MergeSortedLists:");

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        ListNode[] lists = new ListNode[]{l1, l2, l3, l4};

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

        long ocount = 0;
        long count = 0;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (lists.length > 0) {
            ocount++;
            printNodeList(lists);
            int minIndex = -1;
            ListNode tmp = new ListNode(Integer.MAX_VALUE);
            for (int i = 0; i < lists.length; i++) {
                count++;
                ListNode node = lists[i];
                if (node != null) {
                    if (node.val < tmp.val) {
                        minIndex = i;
                        tmp = node;
                    }
                }
            }

            if (minIndex == -1) {
                break;
            }

            tail.next = tmp;
            tail = tail.next;

            if (lists[minIndex].next == null) {
              //  System.arraycopy(a,del+1,a,del,a.length-1-del);
                List<ListNode> l = new ArrayList<>(Arrays.asList(lists));
                l.remove(minIndex);
                lists = l.toArray(lists);
            } else {
                lists[minIndex] = lists[minIndex].next;
            }
        }

        System.out.println("ocount:" + ocount);
        System.out.println("count:" + count);
        return head.next;
    }


    public static ListNode mergeKLists2(ListNode[] lists) {
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
            List<ListNode> l = new ArrayList<>(Arrays.asList(lists));
            l.remove(minIndex);
            lists = l.toArray(lists);
        } else {
            lists[minIndex] = lists[minIndex].next;
        }

        head.next = mergeKLists(lists);
        return head;
    }
}
