package leetcode.easy.phase5;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Optimal;

import java.util.TreeSet;

/**
 * @author qcy
 * @create 2020/12/14 11:24:54
 * 414. 第三大的数
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 */
public class Number414 {

    @Optimal
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(nl)")
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5, 3, 5};
        System.out.println(new Number414().thirdMax(nums));
    }
}
