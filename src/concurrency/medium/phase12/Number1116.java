package concurrency.medium.phase12;

import java.util.function.IntConsumer;

/**
 * @author qcy
 * @create 2020/11/06 09:26:57
 * 1116. 打印零与奇偶数
 *
 * 假设有这么一个类：
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 *
 * 输入：n = 5
 * 输出："0102030405"
 *
 */
public class Number1116 {
    static class ZeroEvenOdd {
        private int n;
        //0:0,1:奇数,2:0,3:偶数
        private volatile int flag = 0;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            synchronized (this) {
                for (int i = 1; i <= n; i++) {
                    while (flag != 0 && flag != 2) {
                        this.wait();
                    }
                    printNumber.accept(0);
                    if (flag == 0) {
                        flag = 1;
                    } else {
                        flag = 3;
                    }
                    this.notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            synchronized (this) {
                for (int i = 2; i <= n; i += 2) {
                    while (flag != 3) {
                        this.wait();
                    }
                    printNumber.accept(i);
                    flag = 0;
                    this.notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            synchronized (this) {
                for (int i = 1; i <= n; i += 2) {
                    while (flag != 1) {
                        this.wait();
                    }
                    printNumber.accept(i);
                    flag = 2;
                    this.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        IntConsumer intConsumer = System.out::print;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
