package leetcode.hard.phase2;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.Array;
import method.Classic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/03/28 20:15:08
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number128 {

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        //每个元素最多被访问两次
        int ans = 1;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int length = 1;
            while (set.contains(++num)) {
                length++;
            }
            ans = Math.max(ans, length);
        }

        return ans;
    }

}
