package leetcode.medium.phase4;

import method.Classic;
import method.Sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/03/12 13:57:54
 * 378. 有序矩阵中第 K 小的元素
 *
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * 
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 *
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 *  
 *
 * 提示：
 *
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= -109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Sort(way = "heap")
public class Number378 {

    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int[] nums : matrix) {
            for (int num : nums) {
                if (queue.size() < k) {
                    queue.offer(num);
                } else {
                    if (queue.peek() > num) {
                        queue.poll();
                        queue.offer(num);
                    }
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 12}, {13, 13, 15}};
        System.out.println(new Number378().kthSmallest(matrix, 8));
    }

}
