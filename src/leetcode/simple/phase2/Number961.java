package leetcode.simple.phase2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qcy
 * @create 2020/09/25 11:34:26
 * 961. 重复 N 次的元素
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 */
public class Number961 {

    public int repeatedNTimes1(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (!set.contains(a)) {
                set.add(a);
            } else {
                return a;
            }
        }
        return A[A.length - 1];
    }

    public int repeatedNTimes(int[] A) {
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] == A[i + 1] || A[i] == A[i + 2]) {
                return A[i];
            }
            if (A[i + 1] == A[i + 2]) {
                return A[i + 1];
            }
        }
        //[1,2,3,1]
        return A[A.length - 1];
    }

}
