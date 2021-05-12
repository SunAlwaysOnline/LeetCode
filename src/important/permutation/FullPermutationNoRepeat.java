package important.permutation;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/05/12 14:14:23
 * 全排列(没有重复的字符)
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class FullPermutationNoRepeat {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(out, in, nums, used);

        return out;
    }

    //深度优先遍历一颗三叉树，注意利用used进行剪枝(子循环不能使用父循环已经使用过的数)
    //在回溯时，需要去掉in最末尾的数字，以及将当前去掉的数字在used中置为未使用过
    @SpaceComplexity("O(n)")
    @TimeComplexity("n^n")
    private void dfs(List<List<Integer>> out, List<Integer> in, int[] nums, boolean[] used) {
        if (in.size() == nums.length) {
            out.add(new ArrayList<>(in));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            in.add(nums[i]);
            dfs(out, in, nums, used);
            in.remove(in.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> out = new FullPermutationNoRepeat().permute(new int[]{1, 2, 3});
        ListUtil.printOut(out);
    }

}
