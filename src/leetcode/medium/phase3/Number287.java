package leetcode.medium.phase3;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.Array;
import method.BinarySearch;
import method.Classic;
import method.InPlace;
import method.Sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/01/21 09:37:59
 * 287. 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3：
 *
 * 输入：nums = [1,1]
 * 输出：1
 * 示例 4：
 *
 * 输入：nums = [1,1,2]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 2 <= n <= 3 * 104
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *  
 *
 * 进阶：
 *
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以在不修改数组 nums 的情况下解决这个问题吗？
 * 你可以只用常量级 O(1) 的额外空间解决这个问题吗？
 * 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number287 {

    @method.Set
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int findDuplicate1(int[] nums) {
        //set直接判断是否重复
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    @Sort()
    @SpaceComplexity("O(nlogn)")
    @TimeComplexity("O(nlogn)")
    public int findDuplicate2(int[] nums) {
        //排序，找出连续出现的数字
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    @InPlace
    public int findDuplicate3(int[] nums) {
        //将数字num放到下标为num-1的位置上
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int temp = nums[nums[i] - 1];
                if (temp == nums[i]) {
                    return temp;
                }
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }

    @BinarySearch
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(nlogn)")
    public int findDuplicate(int[] nums) {
        //二分查找
        int left = 1;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= middle) {
                    count++;
                }
            }

            if (count > middle) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 2};
        System.out.println(new Number287().findDuplicate(nums));
    }

}
