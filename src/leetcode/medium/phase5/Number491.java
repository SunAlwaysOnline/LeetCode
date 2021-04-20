package leetcode.medium.phase5;

import datastructure.Array;
import method.Classic;
import method.PermutationAndCombination;

import java.util.*;

/**
 * @author qcy
 * @create 2021/04/20 14:04:24
 * 491. 递增子序列
 *
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
 * 
 *
 * 示例：
 *
 * 输入：[4, 6, 7, 7]
 * 输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *  
 *
 * 提示：
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
@PermutationAndCombination
public class Number491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        dfs(out, new ArrayList<>(), nums, 0);
        return out;
    }

    private void dfs(List<List<Integer>> out, List<Integer> in, int[] nums, int index) {
        if (in.size() >= 2) {
            out.add(new ArrayList<>(in));
        }
        if (index == nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (in.size() >= 1 && nums[i] < in.get(in.size() - 1)) {
                continue;
            }
            in.add(nums[i]);
            set.add(nums[i]);
            dfs(out, in, nums, i + 1);
            in.remove(in.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 1, 1, 1, 1, 1};
        List<List<Integer>> lists = new Number491().findSubsequences(nums);
        for (List<Integer> in : lists) {
            int[] ints = in.stream().mapToInt(Integer::intValue).toArray();
            System.out.println(Arrays.toString(ints));
        }
    }

}
