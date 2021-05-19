package important.array;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;

import java.util.*;

/**
 * @author qcy
 * @create 2021/05/19 10:39:00
 * 前k高频元素
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class TopKHighFrequencyElements {

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(nlogk)")
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //构造小顶堆
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(key);
                continue;
            }
            if (map.get(key) > map.get(queue.peek())) {
                queue.poll();
                queue.offer(key);
            }
        }

        int[] array = new int[k];
        while (!queue.isEmpty()) {
            array[--k] = queue.poll();
        }

        return array;
    }

    public static void main(String[] args) {
        int[] ans = new TopKHighFrequencyElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
