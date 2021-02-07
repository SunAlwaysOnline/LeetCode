package leetcode.medium.phase1;

import datastructure.BinaryTree;
import method.Classic;
import method.PermutationAndCombination;
import method.Recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/02/07 11:03:08
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
@PermutationAndCombination
@Recall
public class Number39 {
    List<List<Integer>> out = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        dfs(target, 0);
        return out;
    }

    private void dfs(int target, int begin) {
        if (target == 0) {
            out.add(new ArrayList<>(in));
        }
        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            int temp = target - candidates[i];
            if (temp >= 0) {
                in.add(candidates[i]);
                dfs(temp, i);
                in.remove(in.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        new Number39().combinationSum(candidates, 7);
    }

}
