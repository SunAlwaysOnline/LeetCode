package leetcode.medium.phase3;

import method.Classic;
import method.PermutationAndCombination;
import util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/03/01 17:12:25
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number216 {

    List<List<Integer>> out = new ArrayList<>();
    List<Integer> in = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n == 0) {
            return out;
        }
        dfs(k, n, 1);
        return out;
    }

    private void dfs(int k, int n, int start) {
        if (k == 0 && n == 0) {
            out.add(new ArrayList<>(in));
            return;
        }
        //个数够了，但总和不为n
        //个数超过要求
        if (k <= 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            in.add(i);
            dfs(k - 1, n - i, i + 1);
            in.remove(in.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> out = new Number216().combinationSum3(3, 9);
        ListUtil.printOut(out);
    }

}
