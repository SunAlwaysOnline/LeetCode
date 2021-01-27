package interview.medium.phase2;

import datastructure.LinkedList;
import method.Classic;

/**
 * @author qcy
 * @create 2021/01/27 10:20:17
 * 面试题 02.08. 环路检测
 *
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *  
 *
 * 进阶：
 *
 * 你是否可以不用额外空间解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@LinkedList
public class Number02dot08 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println(new Number02dot08().detectCycle(node1).val);
    }

}
