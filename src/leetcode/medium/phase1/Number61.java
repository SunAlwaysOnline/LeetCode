package leetcode.medium.phase1;

import datastructure.LinkedList;

/**
 * @author qcy
 * @create 2021/04/02 14:54:08
 * 61. 旋转链表
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 *
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@LinkedList
public class Number61 {

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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        k %= length;
        if (k == 0) {
            return head;
        }

        //找到待取出的头结点
        ListNode rotateHead = head;
        ListNode pre = null;
        while (length > k) {
            pre = rotateHead;
            rotateHead = rotateHead.next;
            k++;
        }

        pre.next = null;
        ListNode newHead = rotateHead;
        while (rotateHead.next != null) {
            rotateHead = rotateHead.next;
        }
        rotateHead.next = head;
        return newHead;
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

        ListNode node = new Number61().rotateRight(n1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


}
