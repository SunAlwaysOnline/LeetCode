package jzoffer.easy.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import constant.SortWayConstant;
import method.*;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2020/12/14 09:57:40
 * 剑指 Offer 40. 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 */
@Classic
@WaitForOptimize
public class Number40 {

    @Sort
    @Violence
    @SpaceComplexity("O(logn)")
    @TimeComplexity("O(nlogn)")
    @Orignal
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    @Sort(way = SortWayConstant.HEAP_SORT)
    @SpaceComplexity("O(k)")
    @TimeComplexity("O(nlogk)")
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }

        int[] res = new int[k];
        //入堆与出堆的时间复杂度l都是logk
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
                continue;
            }
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int index = 0;
        for (int num : queue) {
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 4, 1, 0, 8};
        Arrays.stream(new Number40().getLeastNumbers(arr, 3)).forEach(System.out::println);
    }
}
