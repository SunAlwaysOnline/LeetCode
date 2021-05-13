package important.linkedList;

import method.DoublePointer;

/**
 * @author qcy
 * @create 2021/05/13 10:41:28
 * 找出环的入口节点
 */
public class FindCycleEntrance {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //快慢指针相遇的结点距离环入口的长度等于头结点到环入口的长度
    @DoublePointer
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        fast = head;
        while (slow != null && fast != null) {
            if (fast == slow) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;

        ListNode node = new FindCycleEntrance().detectCycle(n1);
        System.out.println(node.val);
    }

}
