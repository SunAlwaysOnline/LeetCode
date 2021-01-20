package interview.easy.phase2;

/**
 * @author qcy
 * @create 2021/01/20 18:02:00
 */
public class Number02dot06 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        //   1->2->2->1
        //  1->2->3->2->1
        if (head == null || head.next == null) {
            return true;
        }

        //找到中间节点
        ListNode middle = findMiddleNode(head);
        return false;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
