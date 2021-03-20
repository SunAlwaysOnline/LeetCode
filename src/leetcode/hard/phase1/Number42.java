package leetcode.hard.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;

/**
 * @author qcy
 * @create 2021/03/18 09:37:22
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 *
 * 示例 1：
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 *
 * 提示：
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number42 {

    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n^2)")
    public int trap1(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            //往左寻找最高的墙
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            //往右寻找最高的墙
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int trap(int[] height) {
        int length = height.length;
        //maxLeft[i]表示i左边最高的墙,不包括i
        int[] maxLeft = new int[length];
        //maxRight[i]表示i右边最高的墙，不包括i
        int[] maxRight = new int[length];

        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int trap = new Number42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

}
