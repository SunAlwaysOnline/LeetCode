package leetcode.hard.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.Array;
import method.Classic;
import method.Optimal;
import result.OverTime;

import java.util.Stack;

/**
 * @author qcy
 * @create 2021/03/31 17:22:24
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number84 {

    @OverTime
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n^2)")
    public int largestRectangleArea1(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < length; i++) {
            //往左找到第一个小于当前高度的柱子
            int left = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }

            //往右找到第一个小于当前高度的柱子
            int right = i;
            while (right < length && heights[right] >= heights[i]) {
                right++;
            }

            max = Math.max(max, (right - left - 1) * heights[i]);
        }

        return max;
    }

    @Optimal
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public int largestRectangleArea(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(new Number84().largestRectangleArea(new int[]{1, 4, 5, 2}));
    }

}
