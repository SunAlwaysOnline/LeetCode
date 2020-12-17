package jzoffer.medium.phase1;

/**
 * @author qcy
 * @create 2020/12/17 14:59:04
 * 剑指 Offer 64. 求1+2+…+n
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 */
public class Number64 {

    int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    public int sumNums1(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums1(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Number64().sumNums(3));
    }

}
