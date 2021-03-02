package leetcode.medium.phase1;

import method.Classic;
import method.PermutationAndCombination;
import util.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qcy
 * @create 2021/03/02 13:54:15
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number47 {

    List<List<Integer>> out = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    int[] nums;
    int length;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return out;
        }
        Arrays.sort(nums);
        this.nums = nums;
        length = nums.length;
        used = new boolean[length];
        dfs();
        return out;
    }

    private void dfs() {
        if (in.size() == length) {
            out.add(new ArrayList<>(in));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            in.add(nums[i]);
            used[i] = true;
            dfs();
            in.remove(in.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> out = new Number47().permuteUnique(new int[]{1, 1, 2});
        ListUtil.printOut(out);
    }

}
