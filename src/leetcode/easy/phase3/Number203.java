package leetcode.easy.phase3;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Iteration;

/**
 * @author qcy
 * @create 2020/11/25 17:00:26
 * 203. 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Number203 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Iteration
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //先找到头结点
        ListNode first = head;
        while (first != null && first.val == val) {
            first = first.next;
        }
        if (first == null) {
            return null;
        }

        ListNode pre = first;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode first = new Number203().removeElements(n1, 2);
        while (first != null) {
            System.out.println(first.val);
            first = first.next;
        }

    }

}
