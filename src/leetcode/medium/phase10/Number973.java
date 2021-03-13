package leetcode.medium.phase10;

import datastructure.Heap;
import method.Classic;
import util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/03/13 20:17:10
 * 973. 最接近原点的 K 个点
 *
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Heap
public class Number973 {

    public int[][] kClosest(int[][] points, int k) {
        int length = points.length;
        if (k == length) {
            return points;
        }
        //(k,v)->(索引,距离^2)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(i, (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)));
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(key);
                continue;
            }
            if (map.get(queue.peek()) > map.get(key)) {
                queue.poll();
                queue.offer(key);
            }
        }

        int[][] res = new int[k][2];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            k--;
            res[k] = points[poll];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] pionts = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] res = new Number973().kClosest(pionts, 2);
        ArrayUtil.print(res);
    }

}
