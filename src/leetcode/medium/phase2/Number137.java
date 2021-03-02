package leetcode.medium.phase2;

import method.BitOperation;
import method.Classic;
import method.WaitForOptimize;

/**
 * @author qcy
 * @create 2021/03/02 14:47:40
 * 137. 只出现一次的数字 II
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BitOperation
@WaitForOptimize
public class Number137 {

    public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];

        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                bitCount[i] += num & 1;
                num >>= 1;
            }
        }

        int res = 0;
        for (int count : bitCount) {
            res <<= 1;
            res |= count % 3;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Number137().singleNumber(new int[]{3, 3, 3, 5}));
    }

}
