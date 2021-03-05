package leetcode.medium.phase5;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;
import method.DP;
import method.WaitForOptimize;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2021/03/05 10:05:22
 * 435. 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@DP
@WaitForOptimize
public class Number435 {

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n^2)")
    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int d : dp) {
            max = Math.max(max, d);
        }

        return length - max;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(new Number435().eraseOverlapIntervals(intervals));
    }

}
