package important.desgin;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qcy
 * @create 2021/06/10 15:06:05
 */
public class ProducerAndConsumer {

    private final LinkedList<Integer> list = new LinkedList<>();
    private static final int MAX_CAPACITY = 2;

    class Producer implements Runnable {
        public void run() {
            synchronized (list) {
                while (list.size() == MAX_CAPACITY) {
                    try {
                        list.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                list.add(1);
                System.out.println("生产者" + Thread.currentThread().getName() + "生产, 仓库容量为" + list.size());
                list.notify();
            }
        }
    }

    class Consumer implements Runnable {
        public void run() {
            synchronized (list) {
                while (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                list.removeLast();
                System.out.println("消费者" + Thread.currentThread().getName() + "消费, 仓库容量为" + list.size());
                list.notify();
            }
        }
    }

    //----------------------lock-------------------
    private Lock lock = new ReentrantLock();
    private Condition fullCondition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();

    class Producer2 implements Runnable {
        public void run() {
            lock.lock();
            while (list.size() == MAX_CAPACITY) {
                try {
                    fullCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(1);
            System.out.println("生产者" + Thread.currentThread().getName() + "生产, 仓库容量为" + list.size());
            emptyCondition.signal();
            fullCondition.signal();
            lock.unlock();
        }
    }

    class Consumer2 implements Runnable {
        public void run() {
            lock.lock();
            while (list.isEmpty()) {
                try {
                    emptyCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.removeLast();
            System.out.println("消费者" + Thread.currentThread().getName() + "消费, 仓库容量为" + list.size());
            fullCondition.signal();
            emptyCondition.signal();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer main = new ProducerAndConsumer();
        Producer2 producer = main.new Producer2();
        Consumer2 consumer = main.new Consumer2();

        for (int i = 0; i < 10; i++) {
            new Thread(producer).start();
            new Thread(consumer).start();
        }
    }
}
