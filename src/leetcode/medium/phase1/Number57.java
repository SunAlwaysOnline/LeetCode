package leetcode.medium.phase1;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/04/05 11:07:51
 * 57. 插入区间
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *  
 *
 * 提示：
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        if (length == 0) {
            return new int[][]{newInterval};
        }

        int[][] array = new int[length + 1][2];
        int index = 0;
        int newIndex = 0;
        int arrayIndex = 0;
        while (index < length || newIndex < 1) {
            int[] a = null;
            if (index < length) {
                a = intervals[index];
            }
            int[] b = null;
            if (newIndex < 1) {
                b = newInterval;
            }
            if (a == null) {
                array[arrayIndex++] = b;
                newIndex++;
                continue;
            }
            if (b == null) {
                array[arrayIndex++] = intervals[index++];
                continue;
            }
            if (a[0] <= b[0]) {
                array[arrayIndex++] = intervals[index++];
            } else {
                array[arrayIndex++] = newInterval;
                newIndex++;
            }
        }


        List<int[]> list = new ArrayList<>();
        int left = array[0][0];
        int right = array[0][1];
        for (int i = 1; i < length + 1; i++) {
            if (array[i][0] <= right) {
                right = Math.max(right, array[i][1]);
            } else {
                list.add(new int[]{left, right});
                left = array[i][0];
                right = array[i][1];
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] insert = new Number57().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        ArrayUtil.print(insert);
    }

}
