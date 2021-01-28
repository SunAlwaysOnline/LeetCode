package leetcode.medium.phase12;

import method.Design;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qcy
 * @create 2021/01/28 15:54:38
 */
@Design
public class Number1118 {

    class BoundedBlockingQueue {

        LinkedList<Integer> linkedList;
        Lock lock = new ReentrantLock();
        //在空时等待
        Condition empty = lock.newCondition();
        //在满时等待
        Condition full = lock.newCondition();
        int capacity;

        public BoundedBlockingQueue(int capacity) {
            linkedList = new LinkedList<>();
            this.capacity = capacity;
        }

        public void enqueue(int element) throws InterruptedException {
            lock.lock();
            try {
                while (linkedList.size() == capacity) {
                    full.await();
                }
                linkedList.addFirst(element);
                empty.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public int dequeue() throws InterruptedException {
            lock.lock();
            int i = 0;
            try {
                while (linkedList.isEmpty()) {
                    empty.await();
                }
                i = linkedList.removeLast();
                full.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return i;
        }

        public int size() {
            return linkedList.size();
        }
    }

}
