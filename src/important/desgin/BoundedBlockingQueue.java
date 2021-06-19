package important.desgin;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qcy
 * @create 2021/06/19 19:05:34
 * 阻塞队列
 */
public class BoundedBlockingQueue {
    private Lock lock;
    //在满时等待
    private Condition full;
    //在空时等待
    private Condition empty;

    private LinkedList<Integer> linkedList;
    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        linkedList = new LinkedList<>();
        this.capacity = capacity;

        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
    }

    //在队头新增元素
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

    //删除队尾元素并返回
    public int dequeue() throws InterruptedException {
        lock.lock();
        int last = 0;
        try {
            while (linkedList.size() == 0) {
                empty.await();
            }
            last = linkedList.removeLast();
            full.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return last;
    }

    public int size() {
        return linkedList.size();
    }

}
