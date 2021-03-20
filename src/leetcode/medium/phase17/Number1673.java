package leetcode.medium.phase17;

import datastructure.Array;
import method.MonotonousStack;
import result.OverTime;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/03/18 13:54:39
 * 1673. 找出最具竞争力的子序列
 *
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 *
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 *
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，
 * 那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，
 * 在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 * 示例 2：
 *
 * 输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * 输出：[2,3,3,4]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-most-competitive-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Array
public class Number1673 {

    @OverTime
    public int[] mostCompetitive1(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[k];
        int ansIndex = 0;

        int left = -1;
        while (k != 0) {
            int cur = left;
            int min = nums[length - k];
            for (int i = length - k; i > cur; i--) {
                if (nums[i] <= min) {
                    min = nums[i];
                    left = i;
                }
            }
            ans[ansIndex++] = min;
            k--;
        }
        return ans;
    }

    @MonotonousStack
    public int[] mostCompetitive(int[] nums, int k) {
        int length = nums.length;
        if (k == length) {
            return nums;
        }

        int[] ans = new int[k];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                continue;
            }
            //当前元素比栈顶元素小，且数组剩余长度length-i-1需要大于等于栈中还需要的元素个数
            while (!stack.isEmpty() && nums[i] < stack.peek() && length - i - 1 >= k - stack.size()) {
                stack.pop();
            }
            //如果栈中还缺少元素时
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        while (!stack.isEmpty()) {
            ans[--k] = stack.pop();
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] ans = new Number1673().mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 12);
        for (int i : ans) {
            System.out.println(i);
        }
    }

}
