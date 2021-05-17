package important.linkedList;

/**
 * @author qcy
 * @create 2021/05/17 14:04:20
 * 找到链表的中间结点
 * 如果中间结点有两个,则返回第二个
 */
public class FindMiddle {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
