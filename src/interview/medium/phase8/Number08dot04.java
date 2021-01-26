package interview.medium.phase8;

import method.Classic;
import method.Iteration;
import method.PermutationAndCombination;
import method.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qcy
 * @create 2021/01/26 14:42:14
 * 面试题 08.04. 幂集
 *
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number08dot04 {

    //直接生成
    @Iteration
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = out.size();
            for (int j = 0; j < size; j++) {
                List<Integer> in = new ArrayList<>(out.get(j));
                in.add(nums[i]);
                out.add(in);
            }
        }
        return out;
    }

    //--------------------------------------------------------
    @Recursion
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());
        recrusion(nums, 0, out);
        return out;
    }

    private void recrusion(int[] nums, int index, List<List<Integer>> out) {
        if (index == nums.length) {
            return;
        }
        int size = out.size();
        for (int i = 0; i < size; i++) {
            List<Integer> temp = new ArrayList<>(out.get(i));
            temp.add(nums[index]);
            out.add(temp);
        }
        recrusion(nums, index + 1, out);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        for (List<Integer> subset : new Number08dot04().subsets1(nums)) {
            List<String> collect = subset.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println(String.join(",", collect));
        }
    }

}
