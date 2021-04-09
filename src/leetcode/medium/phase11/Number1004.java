package leetcode.medium.phase11;

import datastructure.Array;
import method.Classic;
import method.SlidingWindow;
import result.OverTime;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/04/09 16:12:49
 * 1004. 最大连续1的个数 III
 *
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number1004 {

    //输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    //输出：6
    int max = 0;

    @OverTime
    public int longestOnes1(int[] A, int K) {
        int length = A.length;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (A[i] == 0) {
                list.add(i + 1);
            }
        }
        if (list.size() <= K) {
            return length;
        }

        dfs(A, K, list);
        return max;
    }

    private void dfs(int[] nums, int count, List<Integer> list) {
        if (count == 0) {
            max = Math.max(max, getMax(nums));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i);
            if (index < 0) {
                continue;
            }
            list.set(i, -index);
            nums[index - 1] = 1;
            dfs(nums, count - 1, list);
            nums[index - 1] = 0;
            list.set(i, index);
        }
    }

    private int getMax(int[] nums) {
        int max = 0;
        int sum = 0;

        for (int num : nums) {
            if (num == 1) {
                sum++;
            } else {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    //----------------------------------------

    @SlidingWindow
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int zeroCount = 0;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeroCount++;
            }
            while (zeroCount > K) {
                if (A[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Number1004().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 0));
    }

}
