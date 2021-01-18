package leetcode.medium.phase1;

import datastructure.LinkedList;
import method.Classic;
import method.DoublePointer;
import method.Optimal;

/**
 * @author qcy
 * @create 2021/01/18 10:39:42
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 */
@Classic
@LinkedList
public class Number19 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Optimal
    @DoublePointer
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;

        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = virtualNode;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            slowPre = slowPre.next;
        }

        slowPre.next = slow.next;
        slow.next = null;

        return virtualNode.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);

        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        ListNode node = new Number19().removeNthFromEnd(n1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
