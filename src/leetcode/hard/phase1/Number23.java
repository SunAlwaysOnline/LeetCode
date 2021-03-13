package leetcode.hard.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.Heap;
import datastructure.LinkedList;
import method.Classic;
import method.Optimal;
import method.Violence;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/03/13 20:32:47
 * 23. 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Heap
@LinkedList
public class Number23 {

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


    @Violence
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(nk)")
    //n为元素总数
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode virtualNode = new ListNode(-1);
        ListNode cur = virtualNode;

        while (true) {
            ListNode minNode = new ListNode(10001);
            int minindex = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) {
                    continue;
                }
                if (node.val < minNode.val) {
                    minNode = node;
                    minindex = i;
                }
            }
            if (minNode.val == 10001) {
                break;
            }
            cur.next = minNode;
            cur = minNode;
            lists[minindex] = minNode.next;
        }

        return virtualNode.next;
    }

    //------------------------------
    @Optimal
    @SpaceComplexity("O(k)")
    @TimeComplexity("O(nlogk)")
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            queue.offer(node);
        }

        ListNode virtualNode = new ListNode(-1);
        ListNode cur = virtualNode;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return virtualNode.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(6);
        n7.next = n8;

        ListNode[] lists = {n1, n4, n7};

        ListNode node = new Number23().mergeKLists(lists);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
