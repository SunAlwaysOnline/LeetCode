package jzoffer.easy.phase1;

import method.Classic;
import method.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/02/19 17:20:09
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@SlidingWindow
public class Number57dot2 {

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        int left = 1;
        int right = 1;
        int sum = 0;

        while (left <= target / 2) {
            if (sum == target) {
                int[] array = new int[right - left];
                for (int i = left; i < right; i++) {
                    array[i - left] = i;
                }
                list.add(array);
                sum -= left;
                left++;
                continue;
            }
            if (sum > target) {
                sum -= left;
                left++;
                continue;
            }
            sum += right;
            right++;
        }

        return list.toArray(new int[0][]);
    }

}
