package leetcode.medium.phase12;

import method.Classic;
import method.MultiThread;

import java.util.concurrent.Semaphore;

/**
 * @author qcy
 * @create 2021/04/21 09:22:35
 * 1117. H2O 生成
 *
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 *
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 *
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 *
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 *
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 *
 * 换句话说:
 *
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * 
 *
 * 示例 1:
 *
 * 输入: "HOH"
 * 输出: "HHO"
 * 解释: "HOH" 和 "OHH" 依然都是有效解。
 * 示例 2:
 *
 * 输入: "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 *  
 *
 * 提示：
 *
 * 输入字符串的总长将会是 3n, 1 ≤ n ≤ 50；
 * 输入字符串中的 “H” 总数将会是 2n 。
 * 输入字符串中的 “O” 总数将会是 n 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/building-h2o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@MultiThread
public class Number1117 {

    class H2O1 {
        int hCount = 0;
        int oCount = 0;
        Object o = new Object();

        public H2O1() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            synchronized (o) {
                while (hCount == 2) {
                    o.wait();
                }
                releaseHydrogen.run();
                hCount++;
                if (hCount == 2 && oCount == 1) {
                    hCount = 0;
                    oCount = 0;
                }
                o.notifyAll();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            synchronized (o) {
                while (oCount == 1) {
                    o.wait();
                }
                releaseOxygen.run();
                oCount++;
                if (hCount == 2 && oCount == 1) {
                    hCount = 0;
                    oCount = 0;
                }
                o.notifyAll();
            }
        }
    }

    //-------------------------------------
    //有问题
    class H2O {
        Semaphore h = new Semaphore(2);
        Semaphore o = new Semaphore(1);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            releaseHydrogen.run();
            if (h.availablePermits() == 0 && o.availablePermits() == 0) {
                h.release(2);
                o.release(1);
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire();
            releaseOxygen.run();
            if (h.availablePermits() == 0 && o.availablePermits() == 0) {
                h.release(2);
                o.release(1);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable releaseHydrogen = () -> System.out.print("h");
        Runnable releaseOxygen = () -> System.out.print("o");

        Number1117 number1117 = new Number1117();
        H2O h2O = number1117.new H2O();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    h2O.oxygen(releaseOxygen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    h2O.hydrogen(releaseHydrogen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
