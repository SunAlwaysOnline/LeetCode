package leetcode.medium.phase3;

import method.BitOperation;
import method.Classic;

/**
 * @author qcy
 * @create 2021/01/08 09:44:09
 * 260. 只出现一次的数字 III
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 */
@Classic
@BitOperation
public class Number260 {

    public int[] singleNumber(int[] nums) {
        //全员异或的结果
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        //从右找出第一个为1的bit位
        int index = 1;
        while ((sum & 1) == 0) {
            index <<= 1;
            sum >>= 1;
        }

        //使用index将数组分为两个部分
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & index) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 7, 1};
        for (int i : new Number260().singleNumber(nums)) {
            System.out.println(i);
        }
    }

}
