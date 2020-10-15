package leetcode.simple.phase3;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qcy
 * @create 2020/10/15 20:08:32
 */
public class Number234 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    
    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        ListNode curNode = head;
        while (curNode != null) {
            list.add(curNode.val);
            curNode = curNode.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(1);
        t1.next = t2;
        t2.next = t3;

        System.out.println(new Number234().isPalindrome(t1));
    }

}

