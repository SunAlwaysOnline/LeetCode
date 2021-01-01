package interview.easy.phase3;

import method.Classic;

import java.util.Stack;

/**
 * @author qcy
 * @create 2020/12/18 14:10:33
 * 面试题 03.04. 化栈为队
 *
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 *
 * 示例：
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 */
@Classic
@datastructure.Stack
public class Number03dot04 {

    class MyQueue {

        Stack<Integer> enterStack;
        Stack<Integer> exitStack;

        public MyQueue() {
            enterStack = new Stack<>();
            exitStack = new Stack<>();
        }

        public void push(int x) {
            enterStack.push(x);
        }

        public int pop() {
            if (exitStack.isEmpty()) {
                while (!enterStack.isEmpty()) {
                    exitStack.push(enterStack.pop());
                }
            }
            if (exitStack.isEmpty()) {
                return -1;
            }
            return exitStack.pop();
        }

        public int peek() {
            if (exitStack.isEmpty()) {
                while (!enterStack.isEmpty()) {
                    exitStack.push(enterStack.pop());
                }
            }
            if (exitStack.isEmpty()) {
                return -1;
            }
            return exitStack.peek();
        }

        public boolean empty() {
            return enterStack.isEmpty() && exitStack.isEmpty();
        }
    }

}
