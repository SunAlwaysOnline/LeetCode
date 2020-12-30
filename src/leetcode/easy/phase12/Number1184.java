package leetcode.easy.phase12;

import method.Optimal;
import method.Violence;

/**
 * @author qcy
 * @create 2020/12/30 15:36:50
 * 1184. 公交站间的距离
 *
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 *  
 *
 * 示例 2：
 *
 *
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 *  
 *
 * 示例 3：
 *
 *
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 *
 */
public class Number1184 {

    @Violence
    public int distanceBetweenBusStops1(int[] distance, int start, int destination) {
        if (distance.length == 1) {
            return 0;
        }
        if (start == destination) {
            return 0;
        }
        //顺时针
        int cw = 0;
        if (start < destination) {
            for (int i = start; i < destination; i++) {
                cw += distance[i];
            }
        } else {
            for (int i = start; i < distance.length; i++) {
                cw += distance[i];
            }
            for (int i = 0; i < destination; i++) {
                cw += distance[i];
            }
        }

        //逆时针
        int acw = 0;
        int sum = 0;
        for (int num : distance) {
            sum += num;
        }
        acw = sum - cw;
        return Math.min(cw, acw);
    }

    @Optimal
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance.length == 1) {
            return 0;
        }
        if (start == destination) {
            return 0;
        }
        if (destination < start) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        //顺时针
        int cw = 0;
        for (int i = start; i < destination; i++) {
            cw += distance[i];
        }

        //逆时针
        int sum = 0;
        for (int num : distance) {
            sum += num;
        }

        return Math.min(cw, sum - cw);
    }

    public static void main(String[] args) {
        int[] distance = {7, 10, 1, 12, 11, 14, 5, 0};
        System.out.println(new Number1184().distanceBetweenBusStops(distance, 7, 2));
    }

}
