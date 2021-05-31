package important.linkedList;

/**
 * @author qcy
 * @create 2021/05/31 13:58:58
 * 找出两条链表相交的点
 */
public class IntersectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;
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
