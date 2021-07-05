package leetcode.easy.phase1;


import method.BinarySearch;
import method.Maths;

/**
 * @author qcy
 * @create 2020/10/06 22:23:10
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number69 {

    @BinarySearch
    public int mySqrt1(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 0;
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (x / mid == mid) {
                return mid;
            }
            if (x / mid < mid) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    @Maths
    //牛顿迭代法
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        double c = x;
        double x0 = x;

        while (true) {
            double xi = 0.5 * (x0 + c / x0);
            if (Math.abs(xi - x0) < 1e-7) {
                break;
            }
            x0 = xi;
        }

        return (int) x0;
    }

    public static void main(String[] args) {
        System.out.println(new Number69().mySqrt(8));
    }

}
