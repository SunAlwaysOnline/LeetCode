package jzoffer.easy.phase1;

import datastructure.LinkedList;
import method.Classic;
import method.DoublePointer;
import method.Violence;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/01/18 09:21:09
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 */
@Classic
@LinkedList
public class Number22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Violence
    public ListNode getKthFromEnd1(ListNode head, int k) {
        if (k == 0) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode node = null;
        while (k-- != 0) {
            node = stack.pop();
        }

        return node;
    }

    @DoublePointer
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k == 0) {
            return null;
        }

        ListNode n1 = head;
        ListNode n2 = head;
        for (int i = 0; i < k; i++) {
            n1 = n1.next;
        }

        while (n1 != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n2;
    }

}
