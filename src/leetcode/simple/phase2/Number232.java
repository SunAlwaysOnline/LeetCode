package leetcode.simple.phase2;

import java.util.Stack;

/**
 * @author qcy
 * @create 2020/09/24 21:03:47
 *232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *  
 *
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *  
 *
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 */
public class Number232 {

    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        //初始化两个栈
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        //往stack1中压入元素
        public void push(int x) {
            stack1.push(x);
        }

        //将stack1中的元素一次性的压入到stack2中
        public void flush() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        //移除stack2的栈顶元素
        public int pop() {
            flush();
            while (!stack2.isEmpty()) {
                return stack2.pop();
            }
            throw new RuntimeException("queue is empty");
        }

        //查看stack2栈顶的元素
        public int peek() {
            flush();
            if (!stack2.isEmpty()) {
                return stack2.peek();
            }
            throw new RuntimeException("queue is empty");
        }

        //判断两个栈是否都为空
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
