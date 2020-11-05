package concurrency.easy.phase12;

/**
 * @author qcy
 * @create 2020/11/05 15:46:00
 * 1114. 按序打印
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 *
 */
public class Number1114 {

    static class Foo {

        public Foo() {

        }

        public volatile int flag = 1;

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (this) {
                printFirst.run();
                flag = 2;
                this.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (this) {
                while (flag != 2) {
                    this.wait();
                }
                printSecond.run();
                flag = 3;
                this.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (this) {
                while (flag != 3) {
                    this.wait();
                }
                printThird.run();
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println(1);
        };

        Runnable r2 = () -> {
            System.out.println(2);
        };

        Runnable r3 = () -> {
            System.out.println(3);
        };

        Foo foo = new Foo();

        new Thread(() -> {
            try {
                foo.second(r2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(r3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
