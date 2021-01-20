package leetcode.medium.phase10;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.Array;
import method.Classic;
import method.Sort;

/**
 * @author qcy
 * @create 2021/01/20 14:12:57
 * 912. 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number912 {

    @Sort(way = "quick")
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    @SpaceComplexity("O(nlogn)")
    @TimeComplexity("O(nlogn)")
    private void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        //每次选择最左边的数作为基准数
        int base = nums[left];
        int i = left;
        int j = right;

        while (i < j) {
            //j从右往左，每次找到一个比base小的数
            while (i < j && nums[j] >= base) {
                j--;
            }
            //i从左往右，每次找到一个比base大的数
            while (i < j && nums[i] <= base) {
                i++;
            }
            if (i < j) {
                //交换这两个数
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        //交换相遇点与base
        nums[left] = nums[i];
        nums[i] = base;

        //递归排序
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {6, 1, 5, 3, 8, 2, 4, 9, 10};
        for (int i : new Number912().sortArray(nums)) {
            System.out.print(i + ",");
        }
    }

}
