package leetcode.simple.phase4;

import method.DoublePointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/10/27 16:43:35
 * 350. 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */
public class Number350 {

    @method.Map
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[nums2.length];
        int index = 0;
        for (int temp : nums2) {
            int count = map.getOrDefault(temp, 0);
            if (count > 0) {
                result[index++] = temp;
                map.put(temp, count - 1);
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }

    @DoublePointer
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                result[index++] = nums1[index1];
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 3};
        int[] nums2 = {1, 4, 6, 1, 2};
        Arrays.stream(new Number350().intersect1(nums1, nums2)).forEach(System.out::println);
    }
}
