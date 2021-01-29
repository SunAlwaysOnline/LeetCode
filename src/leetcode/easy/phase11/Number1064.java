package leetcode.easy.phase11;

import complexity.TimeComplexity;
import datastructure.Array;
import method.Optimal;
import method.Violence;

/**
 * @author qcy
 * @create 2021/01/29 15:18:48
 * 1064. 不动点
 *
 * 给定已经按 升序 排列、由不同整数组成的数组 arr，返回满足 arr[i] == i 的最小索引 i。
 * 如果不存在这样的 i，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [-10,-5,0,3,7]
 * 输出：3
 * 解释：对于给定的数组，arr[0] = -10，arr[1] = -5，arr[2] = 0，arr[3] = 3，因此输出为 3 。
 * 示例 2：
 *
 * 输入：arr = [0,2,5,8,17]
 * 输出：0
 * 解释：arr[0] = 0，因此输出为 0 。
 * 示例 3：
 *
 * 输入：arr = [-10,-5,3,4,7,9]
 * 输出：-1
 * 解释：不存在这样的 i 满足 arr[i] = i，因此输出为 -1 。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length < 104
 * -109 <= arr[i] <= 109
 *  
 *
 * 进阶：时间复杂度为 O(n) 的解决方案很直观也很简单。你可以设计更优的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fixed-point
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Array
public class Number1064 {

    @TimeComplexity("O(n)")
    @Violence
    public int fixedPoint1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                return i;
            }
            if (arr[i] > i) {
                return -1;
            }
        }
        return -1;
    }

    @Optimal
    @TimeComplexity("O(logn)")
    public int fixedPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (arr[middle] >= middle) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left == arr[left] ? left : -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3};
        System.out.println(new Number1064().fixedPoint(arr));
    }

}
