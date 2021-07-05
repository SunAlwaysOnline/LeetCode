package important.math;

import method.BinarySearch;
import method.Maths;

/**
 * @author qcy
 * @create 2021/07/05 09:23:43
 * x的平方根
 */
public class SqrtX {

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
        System.out.println(new SqrtX().mySqrt(8));
    }

}
