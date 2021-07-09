package company.yfd;

/**
 * @author qcy
 * @create 2021/07/09 14:46:23
 * 猿辅导
 * 合并两个有序链表
 */
public class MergeTwoOrderLinkedList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        ListNode resultVirtualNode = new ListNode(-1);
        ListNode resultCur = resultVirtualNode;

        ListNode aCur = a;
        ListNode bCur = b;

        while (aCur != null || bCur != null) {
            if (aCur != null && bCur != null) {
                if (aCur.val > bCur.val) {
                    resultVirtualNode.next = bCur;
                    bCur = bCur.next;
                    resultCur = resultCur.next;
                } else {
                    resultVirtualNode.next = aCur;
                    aCur = aCur.next;
                    resultCur = resultCur.next;
                }
                continue;
            }

            if (aCur != null) {
                resultVirtualNode.next = aCur;
                aCur = aCur.next;
                resultCur = resultCur.next;
                continue;
            }

            resultVirtualNode.next = bCur;
            bCur = bCur.next;
            resultCur = resultCur.next;
        }

        return resultVirtualNode.next;
    }

    public static void main(String[] args) {
    }
}
