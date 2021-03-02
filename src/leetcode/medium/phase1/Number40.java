package leetcode.medium.phase1;

import method.Classic;
import method.PermutationAndCombination;
import util.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qcy
 * @create 2021/03/02 10:35:15
 * 40. 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number40 {

    List<List<Integer>> out = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int length = candidates.length;
        if (length == 0) {
            return out;
        }
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(target, 0);
        return out;
    }

    private void dfs(int leave, int start) {
        if (leave == 0) {
            out.add(new ArrayList<>(in));
        }
        for (int i = start; i < candidates.length; i++) {
            if (leave - candidates[i] < 0) {
                break;
            }
            if (i >= start + 1 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            in.add(candidates[i]);
            dfs(leave - candidates[i], i + 1);
            in.remove(in.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> out = new Number40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        ListUtil.printOut(out);
    }

}
