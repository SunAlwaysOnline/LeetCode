package important.array;

import complexity.TimeComplexity;

/**
 * @author qcy
 * @create 2021/06/17 15:40:59
 * 接雨水
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class ReceiveWater {

    @TimeComplexity("O(n^2)")
    public int trap1(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int sum = 0;
        int length = height.length;

        for (int i = 1; i < length - 1; i++) {
            //向左找到最高的墙
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            //向右找到最高的墙
            int maxRight = 0;
            for (int j = i + 1; j < length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            //如果两者中最矮的墙高于当前墙,则可以存水
            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int sum = 0;
        int length = height.length;

        //leftDp[i]表示i左边最高的墙
        int[] leftDp = new int[length];
        //rightDp[i]表示i右边最高的墙
        int[] rightDp = new int[length];

        for (int i = 1; i < length; i++) {
            leftDp[i] = Math.max(height[i - 1], leftDp[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            rightDp[i] = Math.max(height[i + 1], rightDp[i + 1]);
        }

        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(leftDp[i], rightDp[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

}
