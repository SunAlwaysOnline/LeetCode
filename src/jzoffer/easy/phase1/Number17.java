package jzoffer.easy.phase1;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/11/30 10:31:18
 * 剑指 Offer 17. 打印从1到最大的n位数
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 */
public class Number17 {

    public int[] printNumbers(int n) {
        int max = 1;
        while (n != 0) {
            max *= 10;
            n--;
        }
        max--;

        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        Arrays.stream(new Number17().printNumbers(n)).forEach(System.out::println);
    }
}
