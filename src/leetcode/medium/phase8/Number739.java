package leetcode.medium.phase8;

import datastructure.Array;
import method.Classic;
import method.MonotonousStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author qcy
 * @create 2021/04/03 19:30:53
 * 739. 每日温度
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
@MonotonousStack
public class Number739 {

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        if (length == 0) {
            return new int[0];
        }

        int[] ans = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new Number739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ans));
    }

}
