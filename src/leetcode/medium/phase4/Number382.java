package leetcode.medium.phase4;

import method.WaitForComplete;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author qcy
 * @create 2021/01/25 11:07:13
 */
@WaitForComplete
public class Number382 {

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

    class Solution {
        List<Integer> list;

        public Solution(ListNode head) {
            list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }

        public int getRandom() {
            int index = new Random().nextInt(list.size());
            return list.get(index);
        }
    }


}
