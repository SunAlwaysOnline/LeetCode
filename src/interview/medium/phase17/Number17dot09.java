package interview.medium.phase17;

import datastructure.Heap;
import method.Classic;
import method.Sort;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/03/14 13:20:29
 * 面试题 17.09. 第 k 个数
 *
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Heap
@Sort(way = "heap")
public class Number17dot09 {
    //1,3,5,7,9,15,21,27,35,
    public int getKthMagicNumber(int k) {
        if (k == 0) {
            return 0;
        }
        Queue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);

        Set<Long> set = new HashSet<>();

        while (!queue.isEmpty()) {
            Long poll = queue.poll();
            if (set.add(poll)) {
                queue.offer(poll * 3);
                queue.offer(poll * 5);
                queue.offer(poll * 7);
            }
            if (set.size() == k) {
                return poll.intValue();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Number17dot09().getKthMagicNumber(5));
    }

}
