package jzoffer.hard.phase1;

import datastructure.Heap;
import method.Classic;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/03/25 13:40:05
 * 剑指 Offer 41. 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
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
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *  
 *
 * 限制：
 *
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 * 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Heap
public class Number41 {

    class MedianFinder {
        //小顶堆
        Queue<Integer> a;
        //大顶堆
        Queue<Integer> b;

        //  9        8      7      6
        //a堆底    a堆顶   b堆顶   b堆底
        public MedianFinder() {
            a = new PriorityQueue<>();
            b = new PriorityQueue<>((x, y) -> (y - x));
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
                return (a.peek() + b.peek()) / 2.0d;
            }
            return a.peek();
        }

    }
}
