package jzoffer.medium.phase1;

import method.BitOperation;
import method.Classic;
import method.Orignal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/01/07 15:27:06
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 */
@Classic
public class Number56dot2 {

    @Orignal
    @method.Map
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    @BitOperation
    public int singleNumber(int[] nums) {
        int[] bitArray = new int[32];

        //将每个bit位放进数组中进行统计
        for (int num : nums) {
            int index = 0;
            while (num != 0) {
                bitArray[index++] += num & 1;
                num >>= 1;
            }
        }

        //每个bit位对3取余
        for (int i = 0; i < 32; i++) {
            bitArray[i] = bitArray[i] % 3;
        }

        //将bit位恢复到数字上
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res = res | bitArray[31 - i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4};
        System.out.println(new Number56dot2().singleNumber(nums));
    }
}
