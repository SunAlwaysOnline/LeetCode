package leetcode.medium.phase13;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Recursion;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/02/13 16:35:54
 * 1265. 逆序打印不可变链表
 *
 * 给您一个不可变的链表，使用下列接口逆序打印每个节点的值：
 *
 * ImmutableListNode: 描述不可变链表的接口，链表的头节点已给出。
 * 您需要使用以下函数来访问此链表（您 不能 直接访问 ImmutableListNode）：
 *
 * ImmutableListNode.printValue()：打印当前节点的值。
 * ImmutableListNode.getNext()：返回下一个节点。
 * 输入只用来内部初始化链表。您不可以通过修改链表解决问题。也就是说，您只能通过上述 API 来操作链表。
 * 
 *
 * 进阶：
 *
 * 您是否可以：
 *
 * 使用常数级空间复杂度解决问题？
 * 使用线性级时间复杂度和低于线性级空间复杂度解决问题？
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[4,3,2,1]
 * 示例 2：
 *
 * 输入：head = [0,-4,-1,3,-5]
 * 输出：[-5,3,-1,-4,0]
 * 示例 3：
 *
 * 输入：head = [-2,0,6,4,4,-6]
 * 输出：[-6,4,4,6,0,-2]
 *  
 *
 * 提示：
 *
 * 链表的长度在 [1, 1000] 之间。
 * 每个节点的值在 [-1000, 1000] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-immutable-linked-list-in-reverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1265 {

    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }

    @Recursion
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public void printLinkedListInReverse1(ImmutableListNode head) {
        if (head == null) {
            return;
        }
        printLinkedListInReverse1(head.getNext());
        head.printValue();
    }

    @datastructure.Stack
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public void printLinkedListInReverse2(ImmutableListNode head) {
        ImmutableListNode node = head;
        Stack<ImmutableListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.getNext();
        }

        while (!stack.isEmpty()) {
            stack.pop().printValue();
        }
    }

    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n^2)")
    public void printLinkedListInReverse(ImmutableListNode head) {
        ImmutableListNode fastStart = head.getNext();
        while (fastStart != null) {
            ImmutableListNode fast = fastStart;
            ImmutableListNode slow = head;
            while (fast != null) {
                fast = fast.getNext();
                slow = slow.getNext();
            }
            slow.printValue();
            fastStart = fastStart.getNext();
        }
        head.printValue();
    }

}
