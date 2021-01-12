package leetcode.easy.phase9;

/**
 * @author qcy
 * @create 2021/01/12 14:17:58
 * 896. 单调数列
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * 
 *
 * 示例 1：
 *
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 *
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 *
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 *
 * 输入：[1,1,1]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 *
 */
public class Number896 {

    public boolean isMonotonic(int[] A) {
        int length = A.length;
        if (length <= 1) {
            return true;
        }

        //单调递增
        Boolean incre = null;
        int pre = A[0];
        for (int i = 1; i < length; i++) {
            if (A[i] == pre) {
                continue;
            }
            if (A[i] > pre) {
                if (incre == null) {
                    incre = true;
                }
                if (!incre) {
                    return false;
                }
            }
            if (A[i] < pre) {
                if (incre == null) {
                    incre = false;
                }
                if (incre) {
                    return false;
                }
            }
            pre = A[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {3, 3, 2};
        System.out.println(new Number896().isMonotonic(A));
    }
}
