package leetcode.simple.phase2;

/**
 * @author qcy
 * @create 2020/10/13 17:37:54
 * 160. 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Number160 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        //第一种情况,pA!=pB,说明没相遇,则继续往下走
        //第二种情况,pA==pB,且它们都不为null,则说明相交，交点即为pA
        //第三种情况,pA==pB,且它们都为null,则说明在尾部相遇,没有交点,返回pA,此时pA也为null
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

}
