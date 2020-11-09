package jzoffer.phase1;

/**
 * @author qcy
 * @create 2020/09/28 17:15:46
 *剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 */
public class Number25 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //设置一个虚拟的头结点,最后返回它的下一个结点
        ListNode virtualFirstNode = new ListNode(0);
        //当前结点，每次合并元素后，都会右移
        ListNode currentNode = virtualFirstNode;

        //第一个while,只要l1和l2都还有元素时，依据大小进行合并
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        //第二个while,此时l2已经为空，则将l1剩余的结点合并到新链表中
        while (l1 != null) {
            currentNode.next = l1;
            l1 = l1.next;
            currentNode = currentNode.next;
        }

        //第三个while,此时l1已经为空，则将l2剩余的结点合并到新链表中
        while (l2 != null) {
            currentNode.next = l2;
            l2 = l2.next;
            currentNode = currentNode.next;
        }
        return virtualFirstNode.next;
    }

}
