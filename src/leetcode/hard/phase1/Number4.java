package leetcode.hard.phase1;

import datastructure.Array;
import method.Classic;
import method.Violence;
import method.WaitForOptimize;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2021/03/08 11:24:39
 * 4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *  
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
@WaitForOptimize
public class Number4 {

    @Violence
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int[] nums = new int[length];
        for (int i = 0; i < length1; i++) {
            nums[i] = nums1[i];
        }
        for (int i = length1; i < length; i++) {
            nums[i] = nums2[i - length1];
        }

        Arrays.sort(nums);
        return (length & 1) == 1 ? nums[(length - 1) / 2] : (double) (nums[(length - 1) / 2] + nums[length / 2]) / 2;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int[] nums = new int[length];

        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while (index1 < length1 || index2 < length2) {
            if (index1 == length1) {
                nums[index++] = nums2[index2++];
                continue;
            }
            if (index2 == length2) {
                nums[index++] = nums1[index1++];
                continue;
            }
            if (nums1[index1] < nums2[index2]) {
                nums[index++] = nums1[index1++];
            } else {
                nums[index++] = nums2[index2++];
            }
        }

        return (length & 1) == 1 ? nums[(length - 1) / 2] : (double) (nums[(length - 1) / 2] + nums[length / 2]) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Number4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }

}
