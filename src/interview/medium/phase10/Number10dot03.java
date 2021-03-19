package interview.medium.phase10;

import datastructure.Array;
import method.BinarySearch;
import method.Classic;

/**
 * @author qcy
 * @create 2021/03/19 09:26:10
 * 面试题 10.03. 搜索旋转数组
 *
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 *  输出: 8（元素5在该数组中的索引）
 * 示例2:
 *
 *  输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 *  输出：-1 （没有找到）
 * 提示:
 *
 * arr 长度范围在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-rotate-array-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
@BinarySearch
public class Number10dot03 {

    public int search1(int[] nums, int target) {
        int len = nums.length;

        // 题目给的数据保证数组非空，因此无需再判断

        int left = 0;
        int right = len - 1;
        while (left < right) {

            int mid = (left + right) >>> 1;

            if (nums[mid] < nums[right]) {
                // 此时 [mid, right] 这个区间一定有序
                // 注意：为了让边界收缩行为一直，这里 nums[mid] < target 不取等号，这样才能凑出 left = mid + 1 和后面的分支统一
                if (nums[mid] < target && target <= nums[right]) {
                    // 下一轮搜索区间是 [mid + 1, right]，设置 left = mid
                    left = mid + 1;
                } else {
                    // if 的反面，下一轮搜索区间是 [left, mid]
                    right = mid;
                }

            } else if (nums[mid] > nums[right]) {
                // 此时 [left, mid] 一定有序

                if (nums[left] <= target && target <= nums[mid]) {
                    // 下一轮搜索区间是 [left, mid]
                    right = mid;
                } else {
                    // if 的反面，下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                }
            } else {
                // 此时 nums[mid] == nums[right]

                if (nums[mid] == target) {
                    // {2, 1, 2, 2, 2}; target = 2
                    // mid 的右边一定不是解，下一轮搜索的区间是 [left, mid]
                    right = mid;
                } else {
                    // target = 1
                    // {2, 1, 2, 2, 2};
                    // {2, 2, 2, 1, 2};
                    // 根据上面的例子，只能把 right 这个位置排除掉，下一轮搜索的区间是 [left, right - 1]
                    right--;
                }
            }
        }

        // 有可能区间内不存在目标元素，因此还需做一次判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right == -1)
            return -1;
        while (left < right) {                                         // 循环结束条件left==right
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {                              // 如果左值小于中值，说明左边区间升序
                if (nums[left] <= target && target <= nums[mid]) {     // 如果目标在左边的升序区间中，右边界移动到mid
                    right = mid;
                } else {                                               // 否则目标在右半边，左边界移动到mid+1
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {                       // 如果左值大于中值，说明左边不是升序，右半边升序
                if (nums[left] <= target || target <= nums[mid]) {     // 如果目标在左边，右边界移动到mid
                    right = mid;
                } else {                                               // 否则目标在右半边，左边界移动到mid+1
                    left = mid + 1;
                }
            } else if (nums[left] == nums[mid]) {                      // 如果左值等于中值，可能是已经找到了目标，也可能是遇到了重复值
                if (nums[left] != target) {                            // 如果左值不等于目标，说明还没找到，需要逐一清理重复值。
                    left++;
                } else {                                               // 如果左值等于目标，说明已经找到最左边的目标值
                    right = left;                                      // 将右边界移动到left，循环结束
                }
            }
        }
        return (nums[left] == target) ? left : -1;                     // 返回left，或者-1
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[left] < nums[middle]) {
                //说明[left,middle]有序
                if (nums[left] <= target && target <= nums[middle]) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            } else if (nums[left] > nums[middle]) {
                //说明[middle,right]有序
                if (nums[left] <= target || target <= nums[middle]) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            } else if (nums[left] == nums[middle]) {
                if (nums[left] == target) {
                    right = left;
                } else {
                    left++;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        Number10dot03 solution = new Number10dot03();
        //int[] nums = {21, 21, -21, -20, -17, -8, -6, -2, -2, -1, 0, 2, 3, 4, 4, 6, 11, 13, 14, 16, 17, 18, 20};
        //int target = 4;

        int[] nums = {2, 1, 2, 2, 2};
        int target = 1;
        int res = solution.search(nums, target);
        System.out.println(res);
    }
}


