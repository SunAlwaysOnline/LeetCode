package leetcode.medium.phase6;

import datastructure.Array;
import method.Classic;
import method.PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/03/03 11:13:24
 * 560. 和为K的子数组
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number560 {

    @PrefixSum
    public int subarraySum(int[] nums, int k) {
        //key:前缀和,value:出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            count += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Number560().subarraySum(new int[]{1, 1, 1}, 2));
    }

}
