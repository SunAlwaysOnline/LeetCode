package leetcode.medium.phase4;

import datastructure.Array;
import method.WaitForUnderstand;

/**
 * @author qcy
 * @create 2021/02/10 20:17:41
 * 370. 区间加法
 *
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k​个更新的操作。
 *
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，
 * 你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 *
 * 请你返回 k 次操作后的数组。
 *
 * 示例:
 *
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 * 解释:
 *
 * 初始状态:
 * [0,0,0,0,0]
 *
 * 进行了操作 [1,3,2] 后的状态:
 * [0,2,2,2,0]
 *
 * 进行了操作 [2,4,3] 后的状态:
 * [0,2,5,5,3]
 *
 * 进行了操作 [0,2,-2] 后的状态:
 * [-2,0,3,5,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-addition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Array
@WaitForUnderstand
public class Number370 {

    public int[] getModifiedArray(int length, int[][] updates) {
        // 差分数组 b(n) = a(n) - a(n-1) 类比理解a(n) = S(n) - S(n-1)
        int[] series = new int[length];
        for (int i = 0; i < updates.length; i++) {
            // 差分数组头尾的变更
            series[updates[i][0]] += updates[i][2];
            // 最后一个元素没有后继了，需要特判一下
            if (updates[i][1] < length - 1) {
                series[updates[i][1] + 1] -= updates[i][2];
            }
        }
        // a(n)就是b(n)的前n项和
        // 利用差分数组求原数组
        for (int i = 1; i < series.length; i++) {
            series[i] += series[i - 1];
        }
        return series;
    }

    public static void main(String[] args) {
        int[][] updates = {
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };
        new Number370().getModifiedArray(5, updates);
    }
}
