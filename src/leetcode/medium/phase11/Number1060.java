package leetcode.medium.phase11;

import complexity.TimeComplexity;
import method.BinarySearch;
import method.Classic;

/**
 * @author qcy
 * @create 2021/04/27 14:16:38
 * 1060. 有序数组中的缺失元素
 *
 * 现有一个按 升序 排列的整数数组 nums ，其中每个数字都 互不相同 。
 *
 * 给你一个整数 k ，请你找出并返回从数组最左边开始的第 k 个缺失数字。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,7,9,10], k = 1
 * 输出：5
 * 解释：第一个缺失数字为 5 。
 * 示例 2：
 *
 * 输入：nums = [4,7,9,10], k = 3
 * 输出：8
 * 解释：缺失数字有 [5,6,8,...]，因此第三个缺失数字为 8 。
 * 示例 3：
 *
 * 输入：nums = [1,2,4], k = 3
 * 输出：6
 * 解释：缺失数字有 [3,5,6,7,...]，因此第三个缺失数字为 6 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * 1 <= nums[i] <= 107
 * nums 按 升序 排列，其中所有元素 互不相同 。
 * 1 <= k <= 108
 *  
 *
 * 进阶：你可以设计一个对数时间复杂度（即，O(log(n))）的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinarySearch
public class Number1060 {

    //输入：nums = [1,2,3], k = 1
    @TimeComplexity("O(n)")
    public int missingElement1(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            int miss = nums[i] - nums[i - 1] - 1;
            if (k <= miss) {
                return nums[i - 1] + k;
            }
            k -= miss;
        }
        return nums[nums.length - 1] + k;
    }

    @TimeComplexity("O(logn)")
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        //缺失的数在数组外部
        //nums[right]-nums[left]-1-(right-left-1)
        if (nums[right] - nums[left] - right + left < k) {
            //k-(nums[right]-nums[left]-right+left)+nums[right]
            return k + nums[left] + right + left;
        }
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            //[left,mid]之间的空槽数
            int miss = nums[mid] - nums[left] - mid + left;
            if (miss < k) {
                //空槽数不够
                left = mid;
                k -= miss;
            } else {
                right = mid;
            }
        }
        return nums[left] + k;
    }

    public static void main(String[] args) {
        System.out.println(new Number1060().missingElement(new int[]{2, 4, 6}, 1));
    }

}
