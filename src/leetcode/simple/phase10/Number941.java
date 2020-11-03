package leetcode.simple.phase10;

import method.DoublePointer;
import method.Orignal;

/**
 * @author qcy
 * @create 2020/11/03 09:20:07
 * 941. 有效的山脉数组
 *
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 *
 */
public class Number941 {

    //需要枚举情况，实现复杂
    @Orignal
    public boolean validMountainArray1(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }

        boolean down = false;
        int preNum = A[0];
        //最高点
        int highIndex = 0;
        for (int i = 1; i < A.length; i++) {
            //不能一上来就下降
            if (i == 1 && A[i] < preNum) {
                return false;
            }
            //如果后一个比前一个小,代表下降
            if (A[i] < preNum) {
                if (!down) {
                    highIndex = i - 1;
                }
                down = true;
            }
            //上升的时候,后一个不能比前一个小
            if (!down && A[i] <= preNum) {
                return false;
            }
            //下降的时候,后一个不能比前一个大
            if (down && A[i] >= preNum) {
                return false;
            }
            preNum = A[i];
        }
        if (highIndex == 0 || highIndex == A.length - 1) {
            return false;
        }
        return true;
    }

    @DoublePointer
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int left = 0;
        int rigth = A.length - 1;

        while (left + 1 < A.length && A[left + 1] > A[left]) {
            left++;
        }
        while (rigth > 0 && A[rigth] < A[rigth - 1]) {
            rigth--;
        }

        return left == rigth && left != 0 && rigth != A.length - 1;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new Number941().validMountainArray(A));
    }

}
