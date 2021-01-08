package interview.medium.phase3;

import method.WaitForComplete;

/**
 * @author qcy
 * @create 2021/01/08 17:48:30
 */
@WaitForComplete
public class Number02dot05 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int sum = cal(l1) + cal(l2);
        String sumStr = String.valueOf(sum);
        ListNode virtualNode = new ListNode(-1);
        ListNode pre = virtualNode;
        int index = sumStr.length() - 1;
        while (index >= 0) {
            int val = Integer.parseInt(sumStr.substring(index, index + 1));
            ListNode node = new ListNode(val);
            pre.next = node;
            pre = node;
            index--;
        }

        return virtualNode.next;
    }

    private int cal(ListNode node) {
        int sum = 0;
        int mul = 1;
        while (node != null) {
            sum += node.val * mul;
            mul *= 10;
            node = node.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        //[9]
        //[1,9,9,9,9,9,9,9,9,9]
        ListNode n1 = new ListNode(9);

        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(9);
        ListNode n11 = new ListNode(9);
        ListNode n12 = new ListNode(9);
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;

        ListNode node = new Number02dot05().addTwoNumbers(n1, n3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
