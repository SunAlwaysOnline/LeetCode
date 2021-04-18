package leetcode.medium.phase1;

import method.Classic;
import method.DFS;
import method.Iteration;
import method.PermutationAndCombination;
import util.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qcy
 * @create 2021/04/18 21:05:04
 * 90. 子集 II
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number90 {

    @DFS
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        dfs(out, new ArrayList<>(), 0, nums);
        return out;
    }

    private void dfs(List<List<Integer>> out, List<Integer> in, int start, int[] nums) {
        out.add(new ArrayList<>(in));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            in.add(nums[i]);
            dfs(out, in, i + 1, nums);
            in.remove(in.size() - 1);
        }
    }

    @Iteration
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //判断数字重复的次数
            int count = 1;
            while ((i + 1) < nums.length && nums[i + 1] == nums[i]) {
                count++;
                i++;
            }

            int preSize = out.size();
            for (int j = 0; j < preSize; j++) {
                List<Integer> in = new ArrayList<>(out.get(j));
                for (int t = 1; t <= count; t++) {
                    in.add(nums[i]);
                    out.add(new ArrayList<>(in));
                }
            }
        }

        return out;
    }

    public static void main(String[] args) {
        List<List<Integer>> out = new Number90().subsetsWithDup(new int[]{1, 2, 2});
        ListUtil.print(out);
    }

}
