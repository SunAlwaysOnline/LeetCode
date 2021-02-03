package leetcode.easy.phase16;

import datastructure.Array;
import method.WaitForComplete;

/**
 * @author qcy
 * @create 2021/02/03 13:49:39
 */
@Array
@WaitForComplete
public class Number1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        //(1)

        int[] arr2 = {1, 2};
        //(1),(2)

        int[] arr3 = {1, 2, 3};
        //(1),(2),(3),(1,2,3)

        int[] arr4 = {1, 2, 3, 4};
        //(1),(2),(3),(4),(1,2,3),(2,3,4)

        int[] arr5 = {1, 2, 3, 4, 5};
        //(1),(2),(3),(4),(5),(1,2,3),(2,3,4),(3,4,5),(1,2,3,4,5)

        int[] arr6 = {1, 2, 3, 4, 5, 6};
        //(1),(2),(3),(4),(5),(6),(1,2,3),(2,3,4),(3,4,5),(4,5,6)(1,2,3,4,5),(2,3,4,5,6)
    }

}
