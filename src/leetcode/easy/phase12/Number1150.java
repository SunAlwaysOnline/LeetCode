package leetcode.easy.phase12;

import datastructure.Array;
import method.BinarySearch;
import method.Classic;

/**
 * @author qcy
 * @create 2021/02/20 19:15:15
 * 1150. 检查一个数是否在数组中占绝大多数
 *
 * 给出一个按 非递减 顺序排列的数组 nums，和一个目标数值 target。
 * 假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。
 *
 * 所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [2,4,5,5,5,5,5,6,6], target = 5
 * 输出：true
 * 解释：
 * 数字 5 出现了 5 次，而数组的长度为 9。
 * 所以，5 在数组中占绝大多数，因为 5 次 > 9/2。
 * 示例 2：
 *
 * 输入：nums = [10,100,101,101], target = 101
 * 输出：false
 * 解释：
 * 数字 101 出现了 2 次，而数组的长度是 4。
 * 所以，101 不是 数组占绝大多数的元素，因为 2 次 = 4/2。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^9
 * 1 <= target <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
@BinarySearch
public class Number1150 {

    public boolean isMajorityElement(int[] nums, int target) {
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return false;
        }
        int lastPosition = findLastPosition(nums, target);
        return lastPosition - firstPosition + 1 > nums.length / 2;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target || nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target || nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 5};
        System.out.println(new Number1150().isMajorityElement(nums, 5));
    }

}
