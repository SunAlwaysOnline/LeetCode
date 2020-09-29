package leetcode.simple.phase2;

/**
 * @author qcy
 * @create 2020/09/28 17:17:48
 * 21. 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Number21 {

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //设置一个虚拟的头结点,最后返回它的下一个结点
        ListNode virtualFirstNode = new ListNode(0);
        //当前结点，每次合并元素后，都会右移
        ListNode currentNode = virtualFirstNode;

        //第一个while,只要l1和l2都还有元素时，依据大小进行合并
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        //第二个while,此时l2已经为空，则将l1剩余的结点合并到新链表中
        while (l1 != null) {
            currentNode.next = l1;
            l1 = l1.next;
            currentNode = currentNode.next;
        }

        //第三个while,此时l1已经为空，则将l2剩余的结点合并到新链表中
        while (l2 != null) {
            currentNode.next = l2;
            l2 = l2.next;
            currentNode = currentNode.next;
        }
        return virtualFirstNode.next;
    }
}
