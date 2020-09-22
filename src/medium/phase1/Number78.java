package medium.phase1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/09/22 14:55:05
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Number78 {
    //枚举方案
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //先加入一个空集
        result.add(new ArrayList<>());

        //遍历数组中的元素
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                //遍历之前的所有子集，重新生成一个新的子集
                List<Integer> subList = new ArrayList<>(result.get(i));
                //往新的子集中加入该元素
                subList.add(n);
                //将本次生成的子集加入到结果集中
                result.add(subList);
            }
        }
        return result;
    }

    //位运算方案
    public List<List<Integer>> subsets(int[] nums) {
        //子集的长度是2的nums.length次方，这里通过移位计算
        int length = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>(length);
        //遍历从0到length中间的所有数字，根据数字中1的位置来找子集
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                //如果数字i的某一个位置是1，就把数组中对
                //应的数字添加到集合
                if (((i >> j) & 1) == 1)
                    list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int size = new Number78().subsets(nums).size();
        System.out.println(size);
    }
}
