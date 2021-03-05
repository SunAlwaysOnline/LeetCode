package leetcode.medium.phase1;

import datastructure.Array;
import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qcy
 * @create 2021/01/16 23:00:35
 * 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Array
public class Number56 {

    //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：                [[1,6],[8,10],[15,18]]
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                int[] array = new int[]{left, right};
                list.add(array);
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new Number56().merge(intervals);
        ArrayUtil.print(merge);
    }

}
