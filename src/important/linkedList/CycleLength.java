package important.linkedList;

/**
 * @author qcy
 * @create 2021/05/26 14:59:52
 * 链表环的长度
 */
public class CycleLength {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public int getCycleLength(ListNode head) {
        //首先判断链表是否有环
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
            return 0;
        }

        //找到环的入口结点
        ListNode entrance = null;
        fast = head;
        while (true) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                entrance = fast;
                break;
            }
        }

        //从环的下一个结点开始，直到再次遇到环入口结点
        int length = 0;
        while (true) {
            slow = slow.next;
            length++;
            if (slow == entrance) {
                break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        int length = new CycleLength().getCycleLength(n1);
        System.out.println(length);
    }

}