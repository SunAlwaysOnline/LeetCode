package interview.easy.phase3;

import method.Classic;

import java.util.Stack;

/**
 * @author qcy
 * @create 2020/12/22 09:17:35
 * 面试题 03.02. 栈的最小值
 *
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
@datastructure.Stack
@Classic
public class Number03dot02 {

    static class MinStack {
        Stack<Integer> valueStack;
        Stack<Integer> minStack;

        public MinStack() {
            valueStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            valueStack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
                return;
            }
            int min = Math.min(x, minStack.peek());
            minStack.push(min);
        }

        public void pop() {
            if (!valueStack.isEmpty()) {
                valueStack.pop();
                minStack.pop();
            }
        }

        public int top() {
            if (!valueStack.isEmpty()) {
                return valueStack.peek();
            }
            return -1;
        }

        public int getMin() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }

}
