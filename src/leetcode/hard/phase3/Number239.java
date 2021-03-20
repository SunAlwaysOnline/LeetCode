package leetcode.hard.phase3;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;
import method.Sort;
import method.WaitForOptimize;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/03/16 18:00:52
 * 239. 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number239 {

    @Sort(way = "heap")
    @WaitForOptimize
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(nlogn)")
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length - k + 1];

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        ans[0] = queue.peek()[0];

        for (int i = k; i < length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] array = new Number239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : array) {
            System.out.println(i);
        }
    }

}
