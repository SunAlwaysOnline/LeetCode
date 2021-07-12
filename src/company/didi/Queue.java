package company.didi;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/07/12 20:05:41
 * 两个栈实现队列
 */
public class Queue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    //获取队列大小
    public int size() {
        return stack1.size() + stack2.size();
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    //将stack1中的元素全部插入到stack2中
    private void flush() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    //插入元素
    public void put(int val) {
        stack1.push(val);
    }

    //获取元素
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        flush();
        return stack2.pop();
    }

}