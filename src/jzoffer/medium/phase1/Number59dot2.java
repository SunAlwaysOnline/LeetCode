package jzoffer.medium.phase1;

import method.Classic;
import method.Design;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/15 09:32:01
 * 剑指 Offer 59 - II. 队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 */
@Design
@Classic
public class Number59dot2 {

    static class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> assistQueue;

        public MaxQueue() {
            queue = new LinkedList<>();
            assistQueue = new LinkedList<>();
        }

        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return assistQueue.peekFirst();
        }

        public void push_back(int value) {
            while (!assistQueue.isEmpty() && assistQueue.getLast() < value) {
                assistQueue.pollLast();
            }
            assistQueue.addLast(value);
            queue.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int cur = queue.poll();
            if (cur == assistQueue.peekFirst()) {
                assistQueue.pollFirst();
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
    }
}
