package jzoffer.medium.phase1;

import method.BitOperation;
import method.Classic;

/**
 * @author qcy
 * @create 2021/01/07 10:02:25
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 */
@Classic
@BitOperation
public class Number56dot1 {

    public int[] singleNumbers(int[] nums) {
        //全员异或的结果
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }

        //从低到高找出为1的位数
        int first = 1;
        while ((res & first) == 0) {
            first = first << 1;
        }

        //按照该位是否为1将原数组分为两组，分别进行异或
        int[] arr = new int[2];
        for (int num : nums) {
            if ((num & first) == 0) {
                arr[1] = arr[1] ^ num;
            } else {
                arr[0] = arr[0] ^ num;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2};
        for (int i : new Number56dot1().singleNumbers(nums)) {
            System.out.println(i);
        }
    }

}
