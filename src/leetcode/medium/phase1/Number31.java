package leetcode.medium.phase1;

import datastructure.Array;
import method.Classic;
import method.InPlace;
import method.PermutationAndCombination;

/**
 * @author qcy
 * @create 2021/03/24 09:16:19
 * 31. 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
@Array
public class Number31 {

    @InPlace
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        //从右到左,找到索引k,使得nums[k]<nums[k+1]
        int k = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            //说明数组是降序数组,为最大值,此时直接翻转成最小值
            reverse(nums, 0, length - 1);
            return;
        }

        //从右到左,找到第一个n,使得nums[n]>nums[k]
        int n = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] > nums[k]) {
                n = i;
                break;
            }
        }
        //肯定能找到,最起码能找到n=k+1
        //进行交换
        swap(nums, k, n);

        //翻转[k+1,length-1]
        reverse(nums, k + 1, length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        new Number31().nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

}
