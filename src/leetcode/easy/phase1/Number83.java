package leetcode.easy.phase1;

/**
 * @author qcy
 * @create 2020/09/21 15:42:19
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

public class Number83 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //用于记录头结点
        ListNode currrentNode = head;
        //只要当前节点的值等于下一个节点的值，则删除下一个节点
        while (currrentNode != null && currrentNode.next != null) {
            if (currrentNode.val == currrentNode.next.val) {
                currrentNode.next = currrentNode.next.next;
            } else {
                currrentNode = currrentNode.next;
            }
        }
        return head;
    }

}
