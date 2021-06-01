package important.thread;

/**
 * @author qcy
 * @create 2021/06/01 14:00:24
 */
public class DeadLock {

    private static final Object a = new Object();
    private static final Object b = new Object();

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (a) {
                System.out.println("Thread1获取到了a的对象锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1等待b的对象锁");
                synchronized (b) {
                    System.out.println("Thread1获取到了b的对象锁");
                }
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (b) {
                System.out.println("Thread2获取到了b的对象锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2等待a的对象锁");
                synchronized (a) {
                    System.out.println("Thread2获取到了a的对象锁");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

}
