package jzoffer.easy.phase1;

import java.util.Stack;

/**
 * @author qcy
 * @create 2020/12/02 15:41:11
 * 剑指 Offer 30. 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 */
public class Number30 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
                return;
            }
            int min = Math.min(minStack.peek(), x);
            minStack.push(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            return -1;
        }

        public int min() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            return -1;
        }
    }

}
