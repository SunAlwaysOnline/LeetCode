package leetcode.medium.phase2;

import datastructure.Array;
import datastructure.BinaryTree;
import method.BinarySearch;
import method.Classic;

/**
 * @author qcy
 * @create 2021/03/19 10:40:36
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
@BinarySearch
public class Number153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else if (nums[middle] < nums[right]) {
                //中值有可能是最小元素
                right = middle;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Number153().findMin(new int[]{7, 8, 1, 2, 3, 4, 5, 6}));
    }
}
