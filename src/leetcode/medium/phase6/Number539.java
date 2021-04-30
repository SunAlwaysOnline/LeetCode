package leetcode.medium.phase6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author qcy
 * @create 2021/04/30 10:54:09
 * 539. 最小时间差
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number539 {

    public int findMinDifference(List<String> timePoints) {
        timePoints.sort(String::compareTo);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            ans = Math.min(ans, diff(timePoints.get(i), timePoints.get(i + 1)));
        }

        ans = Math.min(ans, diff(timePoints.get(timePoints.size() - 1), getTimeAdd24(timePoints.get(0))));

        return ans;
    }

    //要求a时间不能比b时间晚
    private int diff(String a, String b) {
        if (Objects.equals(a, b)) {
            return 0;
        }

        String[] as = a.split(":");
        String[] bs = b.split(":");

        int h = Integer.parseInt(bs[0]) - Integer.parseInt(as[0]);
        int m = Integer.parseInt(bs[1]) - Integer.parseInt(as[1]);
        return h * 60 + m;
    }

    //将当前时间的小时加上24
    private String getTimeAdd24(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]) + 24;
        String m = split[1];
        return h + ":" + m;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //["05:31","22:08","00:35"]
        list.add("05:31");
        list.add("22:08");
        list.add("00:35");
        int difference = new Number539().findMinDifference(list);
        System.out.println(difference);
    }

}
