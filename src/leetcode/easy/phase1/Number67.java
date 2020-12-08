package leetcode.easy.phase1;

import method.Orignal;

/**
 * @author qcy
 * @create 2020/12/08 09:14:51
 * 67. 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 */
public class Number67 {

    @Orignal
    public String addBinary(String a, String b) {
        char[] res = new char[Math.max(a.length(), b.length()) + 1];

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int index = res.length - 1;
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        boolean carry = false;

        while (aIndex >= 0 && bIndex >= 0) {
            int aNum = Integer.parseInt(String.valueOf(aArray[aIndex--]));
            int bNum = Integer.parseInt(String.valueOf(bArray[bIndex--]));
            if (carry) {
                if (aNum + bNum == 0) {
                    res[index--] = '1';
                    carry = false;
                } else if (aNum + bNum == 1) {
                    res[index--] = '0';
                    carry = true;
                } else {
                    res[index--] = '1';
                    carry = true;
                }
            } else {
                if (aNum + bNum == 0) {
                    res[index--] = '0';
                    carry = false;
                } else if (aNum + bNum == 1) {
                    res[index--] = '1';
                    carry = false;
                } else {
                    res[index--] = '0';
                    carry = true;
                }
            }
        }

        //a比b长,此时a还没用完
        while (aIndex >= 0) {
            int aNum = Integer.parseInt(String.valueOf(aArray[aIndex--]));
            if (carry) {
                if (aNum == 1) {
                    res[index--] = '0';
                    carry = true;
                } else {
                    res[index--] = '1';
                    carry = false;
                }
            } else {
                if (aNum == 1) {
                    res[index--] = '1';
                    carry = false;
                } else {
                    res[index--] = '0';
                    carry = false;
                }
            }
        }


        while (bIndex >= 0) {
            int bNum = Integer.parseInt(String.valueOf(bArray[bIndex--]));
            if (carry) {
                if (bNum == 1) {
                    res[index--] = '0';
                    carry = true;
                } else {
                    res[index--] = '1';
                    carry = false;
                }
            } else {
                if (bNum == 1) {
                    res[index--] = '1';
                    carry = false;
                } else {
                    res[index--] = '0';
                    carry = false;
                }
            }
        }

        if (carry) {
            res[index] = '1';
        } else {
            int originalLength = res.length;
            char[] array = new char[originalLength - 1];
            for (int i = 1; i < originalLength; i++) {
                array[i - 1] = res[i];
            }
            res = array;
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "101";
        System.out.println(new Number67().addBinary(a, b));
    }
}
