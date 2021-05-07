package important.linkedList;

import method.FastAndSlowPointer;

/**
 * @author qcy
 * @create 2021/05/07 14:14:24
 * 判断链表是否有环
 */
public class HasCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @FastAndSlowPointer
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

}
