package jzoffer.easy.phase1;

import datastructure.LinkedList;
import method.Classic;

/**
 * @author qcy
 * @create 2020/12/21 09:17:34
 * 剑指 Offer 24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 */
@LinkedList
@Classic
public class Number24 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode virtualHead = new ListNode(-1);
        virtualHead.next = head;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            pre.next = cur.next;
            cur.next = virtualHead.next;
            virtualHead.next = cur;
            cur = pre.next;
        }
        return virtualHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode res = new Number24().reverseList(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

}
