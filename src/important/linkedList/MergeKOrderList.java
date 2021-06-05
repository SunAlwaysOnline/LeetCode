package important.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/06/05 09:52:08
 * 合并K个链表
 */
public class MergeKOrderList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode virtualNode = new ListNode();
        ListNode cur = virtualNode;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            queue.offer(node);
        }

        while (!queue.isEmpty()) {

            ListNode poll = queue.poll();
            cur.next = poll;
            cur = cur.next;

            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }

        return virtualNode.next;
    }

}
