package leetcode.easy.phase13;

import method.BitOperation;
import method.Orignal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/11/04 09:24:34
 * 1290. 二进制链表转整数
 *
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 示例 1：
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 *
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 *
 * 输入：head = [0,0]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 *
 */
public class Number1290 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Orignal
    public int getDecimalValue1(ListNode head) {
        int result = 0;
        List<Integer> path = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            path.add(cur.val);
            cur = cur.next;
        }

        for (int i = 0; i < path.size(); i++) {
            result += path.get(i) * Math.pow(2, path.size() - i - 1);
        }

        return result;
    }

    @BitOperation
    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode cur = head;
        while (cur != null) {
            result = (result << 1) + cur.val;
            //result = result * 2 + cur.val;
            cur = cur.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;

        System.out.println(new Number1290().getDecimalValue(node1));
    }

}
