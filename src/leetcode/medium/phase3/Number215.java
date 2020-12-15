package leetcode.medium.phase3;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import constant.SortWayConstant;
import method.Classic;
import method.Sort;

import java.util.PriorityQueue;

/**
 * @author qcy
 * @create 2020/12/15 15:58:28
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 */
@Classic
public class Number215 {

    @Sort(way = SortWayConstant.HEAP_SORT)
    @SpaceComplexity("O(k)")
    @TimeComplexity("O(nlogk)")
    public int findKthLargest(int[] nums, int k) {
        //生成一个
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k || queue.isEmpty()) {
                queue.offer(num);
                continue;
            }
            if (queue.peek() < num) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(new Number215().findKthLargest(nums, 2));
    }
}
