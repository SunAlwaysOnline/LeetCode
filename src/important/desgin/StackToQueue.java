package important.desgin;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/05/18 14:12:09
 * 两个栈实现队列
 */
public class StackToQueue {

    class MyQueue {

        //只往stack1里push,只从stack2中读取
        //stack2为空时,需要将stack1里所有数据push进stack2中
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        private void flush() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) {
                    throw new RuntimeException("queue is empty");
                }
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        public int pop() {
            flush();
            return stack2.pop();
        }

        public int peek() {
            flush();
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
