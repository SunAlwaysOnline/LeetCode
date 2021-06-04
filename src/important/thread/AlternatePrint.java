package important.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qcy
 * @create 2021/06/04 16:11:41
 */
public class AlternatePrint {
    private final Object object = new Object();
    private int i = 1;
    private static final int MAX = 100;

    class MyRunnable implements Runnable {
        public void run() {
            synchronized (object) {
                while (i <= MAX) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    object.notify();

                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //防止子线程被阻塞，主线程无法退出
                    object.notify();
                }
            }
        }
    }

    //-------------------------------------------------------
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    class LockRunnable implements Runnable {
        public void run() {
            lock.lock();
            try {
                while (i <= MAX) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    condition.signal();
                    condition.await();
                    //防止子线程被阻塞，主线程无法退出
                    condition.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        AlternatePrint alternatePrint = new AlternatePrint();
        MyRunnable runnable = alternatePrint.new MyRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

}
