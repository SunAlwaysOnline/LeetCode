package leetcode.medium.phase7;

import datastructure.Array;
import method.Classic;

/**
 * @author qcy
 * @create 2021/04/13 09:19:04
 * 670. 最大交换
 *
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 108]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number670 {

    //输入: 2736
    //输出: 7236
    //解释: 交换数字2和数字7。
    //
    //输入: 9973
    //输出: 9973
    //解释: 不需要交换。
    public int maximumSwap(int num) {
        if (num == 0) {
            return 0;
        }

        String s = String.valueOf(num);
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] maxIndexArray = new int[length];

        int maxIndex = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] > chars[maxIndex]) {
                maxIndex = i;
            }
            maxIndexArray[i] = maxIndex;
        }

        for (int i = 0; i < length; i++) {
            if (chars[i] == chars[maxIndexArray[i]]) {
                continue;
            }
            char temp = chars[i];
            chars[i] = chars[maxIndexArray[i]];
            chars[maxIndexArray[i]] = temp;
            break;
        }

        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(new Number670().maximumSwap(2763));
    }

}
