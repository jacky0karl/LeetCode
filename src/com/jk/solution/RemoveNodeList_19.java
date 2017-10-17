package com.jk.solution;

import java.util.ArrayList;
import java.util.List;

public class RemoveNodeList_19 {

    public static void test() {
        System.out.println("21 Merge Two Sorted Lists:");

        ListNode l1 = new ListNode(0);
        ListNode n1 = l1;
        n1.next = new ListNode(1);
        n1 = n1.next;
        n1.next = new ListNode(2);
        n1 = n1.next;
        n1.next = new ListNode(3);
        n1 = n1.next;
        n1.next = new ListNode(4);


        ListNode ret = removeNthFromEnd(l1, 2);
        StringBuilder sb = new StringBuilder();
        while (ret != null) {
            sb.append(ret.val);
            sb.append(", ");
            ret = ret.next;
        }
        System.out.println(sb.toString());
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode revert(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        head.next = null;
        return prev;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }

        int index = list.size() - n;
        if (index < 0) {
            return head;
        }
        if (index == 0) {
            return head.next;
        }

        if (index + 1 > list.size() - 1) {
            list.get(index - 1).next = null;
        } else {
            list.get(index - 1).next = list.get(index + 1);
        }
        return head;
    }
}
