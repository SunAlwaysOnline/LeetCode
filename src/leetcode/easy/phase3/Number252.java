package leetcode.easy.phase3;

import datastructure.Array;
import method.Classic;
import method.Optimal;
import method.Orignal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qcy
 * @create 2021/01/29 11:27:23
 * 252. 会议室
 *
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 请你判断一个人是否能够参加这里面的全部会议。
 * 
 *
 * 示例 1：
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 * 示例 2：
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti < endi <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/meeting-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number252 {

    @Orignal
    public boolean canAttendMeetings1(int[][] intervals) {
        List<int[]> list = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(o -> o[0]))
                .collect(Collectors.toList());
        for (int i = 0; i < list.size() - 1; i++) {
            int[] pre = list.get(i);
            int[] after = list.get(i + 1);
            if (pre[1] > after[0]) {
                return false;
            }
        }
        return true;
    }

    @Optimal
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] pre = intervals[i];
            int[] after = intervals[i + 1];
            if (pre[1] > after[0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20}
        };
        System.out.println(new Number252().canAttendMeetings(intervals));
    }
}
