package interview.medium.phase17;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.Heap;
import method.Classic;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/22 10:06:43
 * 面试题 17.14. 最小K个数
 *
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 */
@Heap
@Classic
public class Number17dot14 {

    @SpaceComplexity("O(k)")
    @TimeComplexity("O(nlogk)")
    public int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        if (k == 0) {
            return new int[0];
        }
        //构造大顶堆
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
                continue;
            }
            if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }

        int[] res = new int[k];
        int index = 0;
        for (Integer num : queue) {
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        Arrays.stream(new Number17dot14().smallestK(arr, 4)).forEach(System.out::println);
    }

}
