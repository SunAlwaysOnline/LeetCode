package leetcode.medium.phase1;

import method.Classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/01/09 21:37:05
 * 46. 全排列
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
@Classic
public class Number46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        recursion(outer, list, nums);
        return outer;
    }

    public void recursion(List<List<Integer>> res, List<Integer> list, int[] nums) {
        //递归终止条件，当list长度达到数组长度时，表示找到一个排列，加入到结果队列中，并终止本层递归调用
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        //这部分确实有点抽象，得靠画图理解
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            recursion(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

}
