package leetcode.medium.phase1;

import java.util.*;

/**
 * @author qcy
 * @create 2020/09/24 19:31:25
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 */
public class Number347 {
    //堆排
    public int[] topKFrequent(int[] nums, int k) {
        //建立数字与其频率的映射关系
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //构造小顶堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //堆内元素数量不足k,则直接插入
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            } else {
                //判断堆顶元素与新元素的频率
                int time = map.get(queue.peek());
                if (time < map.get(entry.getKey())) {
                    //如果堆顶元素的评率小于新元素的频率,则将堆顶元素出堆,并将新元素入堆
                    queue.poll();
                    queue.offer(entry.getKey());
                }
            }
        }

        int[] result = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }

        return result;
    }

    //快排
    public int[] topKFrequent1(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (int i = 0; i < k; i++) {
            result[i] = list.get(list.size() - i - 1).getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3, 3, 3, 4};
        int[] array = new Number347().topKFrequent(nums, 2);
        Arrays.stream(array).forEach(System.out::println);
    }
}
