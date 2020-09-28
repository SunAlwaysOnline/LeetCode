package leetcode.simple.phase2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/09/27 20:09:00
 */
public class Number225 {


    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            //颠倒队列元素顺序
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.size() == 0;
        }
    }


}
