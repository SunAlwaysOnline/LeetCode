package important.linkedList;

/**
 * @author qcy
 * @create 2021/05/30 20:33:42
 * 链表求和
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode virtualNode = new ListNode(-1);
        ListNode pre = virtualNode;

        boolean carry = false;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry ? 1 : 0;
            ListNode cur = new ListNode(sum % 10);
            pre.next = cur;
            carry = sum > 9;
            pre = cur;
        }

        if (carry) {
            pre.next = new ListNode(1);
        }

        return virtualNode.next;
    }

}
