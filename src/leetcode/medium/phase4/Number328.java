package leetcode.medium.phase4;

import datastructure.LinkedList;
import method.Classic;

/**
 * @author qcy
 * @create 2021/04/09 09:16:34
 * 328. 奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@LinkedList
public class Number328 {

    public static class ListNode {
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

    //输入: 2->1->3->5->6->4->7->NULL
    //输出: 2->3->6->7->1->5->4->NULL
    public ListNode oddEvenList(ListNode head) {
        //奇链表的虚拟头结点
        ListNode aHead = new ListNode();
        ListNode aCur = aHead;
        //偶链表的虚拟头结点
        ListNode bHead = new ListNode();
        ListNode bCur = bHead;

        ListNode cur = head;
        boolean flag = true;
        while (cur != null) {
            if (flag) {
                aCur.next = cur;
                aCur = aCur.next;
            } else {
                bCur.next = cur;
                bCur = bCur.next;
            }
            cur = cur.next;
            flag = !flag;
        }

        aCur.next = bHead.next;
        bCur.next = null;
        return aHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node = new Number328().oddEvenList(n1);
        while (node != null) {
            System.out.println(node.val + ",");
            node = node.next;
        }
    }

}
