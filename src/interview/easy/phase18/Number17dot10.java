package interview.easy.phase18;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;

/**
 * @author qcy
 * @create 2020/12/07 15:15:46
 * 面试题 17.10. 主要元素
 *
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 *  
 *
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 *
 */
public class Number17dot10 {

    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            count += nums[i] == cur ? 1 : -1;
            if (count == 0) {
                cur = nums[i];
                count = 1;
            }
        }

        count = 0;
        for (int num : nums) {
            if (cur == num) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return cur;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 12, 2, 1};
        System.out.println(new Number17dot10().majorityElement(nums));
    }

}
