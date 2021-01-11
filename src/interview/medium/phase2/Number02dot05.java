package interview.medium.phase2;

import datastructure.LinkedList;
import exception.NumericOverflow;
import method.Classic;
import method.Optimal;
import method.Orignal;

/**
 * @author qcy
 * @create 2021/01/08 17:48:30
 * 面试题 02.05. 链表求和
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 */
@Classic
@LinkedList
public class Number02dot05 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Orignal
    @NumericOverflow
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int sum = cal1(l1) + cal1(l2);
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

    private int cal1(ListNode node) {
        int sum = 0;
        int mul = 1;
        while (node != null) {
            sum += node.val * mul;
            mul *= 10;
            node = node.next;
        }
        return sum;
    }

    //-----------------------------------------------------------------------
    @Optimal
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

        ListNode virtualHead = new ListNode(-1);
        ListNode pre = virtualHead;
        boolean carry = false;
        while (l1 != null && l2 != null) {
            int val = carry ? l1.val + l2.val + 1 : l1.val + l2.val;
            if (val > 9) {
                carry = true;
                val %= 10;
            } else {
                carry = false;
            }
            pre.next = new ListNode(val);
            pre = pre.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = carry ? l1.val + 1 : l1.val;
            if (val > 9) {
                carry = true;
                val %= 10;
            } else {
                carry = false;
            }
            pre.next = new ListNode(val);
            pre = pre.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int val = carry ? l2.val + 1 : l2.val;
            if (val > 9) {
                carry = true;
                val %= 10;
            } else {
                carry = false;
            }
            pre.next = new ListNode(val);
            pre = pre.next;

            l2 = l2.next;
        }
        if (carry) {
            pre.next = new ListNode(1);
        }
        return virtualHead.next;
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
