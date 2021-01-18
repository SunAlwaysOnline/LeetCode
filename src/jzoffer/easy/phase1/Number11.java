package jzoffer.easy.phase1;

/**
 * @author qcy
 * @create 2021/01/18 13:50:22
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 */
public class Number11 {

    public int minArray(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            if (i + 1 == length) {
                return numbers[0];
            }
            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1];
            }
        }
        return -1;
    }

}
