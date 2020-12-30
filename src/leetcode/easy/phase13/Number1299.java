package leetcode.easy.phase13;

import method.Optimal;
import method.Violence;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/12/30 13:53:02
 * 1299. 将每个元素替换为右侧最大元素
 *
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 *
 * 完成所有替换操作后，请你返回这个数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 *
 */
public class Number1299 {

    //输入：arr = [17,18,5,4,6,1]
    //输出：      [18,6,6,6,1,-1]
    @Violence
    public int[] replaceElements1(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int max = Integer.MIN_VALUE;
            if (i == length - 1) {
                arr[i] = -1;
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                max = Math.max(max, arr[j]);
            }
            arr[i] = max;
        }
        return arr;
    }

    @Optimal
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        int rigthMax = arr[length - 1];
        arr[length - 1] = -1;

        for (int i = length - 2; i >= 0; i--) {
            int t = arr[i];
            arr[i] = rigthMax;
            if (t > rigthMax) {
                rigthMax = t;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        Arrays.stream(new Number1299().replaceElements(arr)).forEach(System.out::println);
    }

}
