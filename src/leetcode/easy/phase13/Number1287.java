package leetcode.easy.phase13;

/**
 * @author qcy
 * @create 2021/01/07 09:32:32
 * 1287. 有序数组中出现次数超过25%的元素
 *
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 *  
 *
 * 示例：
 *
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 *
 */
public class Number1287 {

    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int sum = length / 4;

        int preSum = 0;
        int preNum = -1;
        for (int num : arr) {
            if (num != preNum) {
                //先算之前的数出现的次数
                if (preSum > sum) {
                    return preNum;
                }
                preNum = num;
                preSum = 1;
            } else {
                preSum++;
            }
        }
        return preNum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(new Number1287().findSpecialInteger(arr));
    }

}
