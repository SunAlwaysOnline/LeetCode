package interview.hard.phase17;

import complexity.TimeComplexity;
import datastructure.Array;
import method.Classic;

/**
 * @author qcy
 * @create 2021/04/02 09:46:43
 * 面试题 17.21. 直方图的水量
 *
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 
 * 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number17dot21 {

    @TimeComplexity("O(n^2)")
    public int trap1(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            int maxLeft = 0;
            for (int m = i - 1; m >= 0; m--) {
                maxLeft = Math.max(maxLeft, height[m]);
            }

            int maxRight = 0;
            for (int n = i + 1; n < length; n++) {
                maxRight = Math.max(maxRight, height[n]);
            }

            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    @TimeComplexity("O(n)")
    public int trap(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }

        //maxLeft[i]代表i左边最高的墙，不包括i
        int[] maxLeft = new int[length];
        //maxRight[i]代表i右边最高的墙，不包括i
        int[] maxRight = new int[length];

        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Number17dot21().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
