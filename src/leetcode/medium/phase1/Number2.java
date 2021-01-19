package leetcode.medium.phase1;

import datastructure.LinkedList;
import method.Classic;
import method.Optimal;
import result.Tedious;

/**
 * @author qcy
 * @create 2021/01/19 10:07:13
 * 2. 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@LinkedList
public class Number2 {

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

    @Tedious
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode virtualNode = new ListNode(0);
        ListNode cur = virtualNode;
        boolean carry = false;

        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1 + val2;
            if (carry) {
                sum += 1;
            }
            if (sum > 9) {
                carry = true;
                sum %= 10;
            } else {
                carry = false;
            }

            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val;
            if (carry) {
                val += 1;
            }
            if (val > 9) {
                carry = true;
                val %= 10;
            } else {
                carry = false;
            }
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = node;

            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val;
            if (carry) {
                val += 1;
            }
            if (val > 9) {
                carry = true;
                val %= 10;
            } else {
                carry = false;
            }
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = node;

            l2 = l2.next;
        }
        if (carry) {
            cur.next = new ListNode(1);
        }
        return virtualNode.next;
    }

    @Optimal
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode virtualNode = new ListNode(0);
        ListNode cur = virtualNode;
        boolean carry = false;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry) {
                sum += 1;
            }

            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = node;

            carry = sum > 9;
        }

        if (carry) {
            cur.next = new ListNode(1);
        }
        ListNode head = virtualNode.next;
        virtualNode.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        n4.next = n5;

        ListNode node = new Number2().addTwoNumbers(n1, n4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

}
