package leetcode.medium.phase4;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.LinkedList;
import method.Classic;
import method.Optimal;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/02/18 18:55:57
 * 369. 给单链表加一
 *
 * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
 *
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 *
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@LinkedList
public class Number369 {

    public class ListNode {
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

    @datastructure.Stack
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public ListNode plusOne1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        boolean carry = false;
        ListNode listNode = null;
        while (!stack.isEmpty()) {
            int val = 0;
            if (listNode == null) {
                val += 1;
            }
            listNode = stack.pop();
            val += carry ? listNode.val + 1 : listNode.val;
            listNode.val = val % 10;
            carry = val > 9;
        }

        if (!carry) {
            return listNode;
        }

        ListNode newHead = new ListNode(1);
        newHead.next = listNode;
        return newHead;
    }

    @Optimal
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public ListNode plusOne(ListNode head) {
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }

        slow.val += 1;
        ListNode cur = slow.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        return slow.next == head ? slow : head;
    }

}
