package leetcode.hard.phase3;

import datastructure.Heap;
import method.Classic;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/03/25 14:17:34
 * 295. 数据流的中位数
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Heap
public class Number295 {

    class MedianFinder {

        Queue<Integer> a;
        Queue<Integer> b;

        public MedianFinder() {
            a = new PriorityQueue<>();
            b = new PriorityQueue<>((x, y) -> y - x);
        }

        public void addNum(int num) {
            if (a.size() == b.size()) {
                b.add(num);
                a.add(b.poll());
            } else {
                a.add(num);
                b.add(a.poll());
            }
        }

        public double findMedian() {
            if (a.size() == 0) {
                return 0.0;
            }
            if (a.size() == b.size()) {
                return (a.peek() + b.peek()) / 2.0;
            }
            return a.peek();
        }
    }

}
