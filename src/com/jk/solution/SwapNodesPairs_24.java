package com.jk.solution;

public class SwapNodesPairs_24 {

    public static void test() {
        System.out.println("24 Swap Nodes Pairs:");
        ListNode l1 = new ListNode(1);
        ListNode t1 = l1;
        t1.next = new ListNode(2);
        t1 = t1.next;
        t1.next = new ListNode(3);
        t1 = t1.next;
        t1.next = new ListNode(4);
        t1 = t1.next;
        t1.next = new ListNode(5);
      //  t1 = t1.next;
      //  t1.next = new ListNode(6);

        ListNode ret = swapPairs(l1);
        printNode(ret);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if ((head == null || head.next == null)) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr = dummy.next;
        while (curr != null && curr.next != null) {
            ListNode tmp = curr.next;
            curr.next = curr.next.next;
            tmp.next = curr;
            pre.next = tmp;

            pre = curr;
            curr = curr.next;
        }

        return dummy.next;
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
}
