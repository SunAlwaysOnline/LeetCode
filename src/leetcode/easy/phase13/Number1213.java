package leetcode.easy.phase13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qcy
 * @create 2021/02/26 15:01:39
 * 1213. 三个有序数组的交集
 *
 * 给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。
 *
 * 返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。
 * 
 *
 * 示例：
 *
 * 输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * 输出: [1,5]
 * 解释: 只有 1 和 5 同时在这三个数组中出现.
 *  
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 * 通过次数4,715提交次数6,174
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-three-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1213 {

    //arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] arr = find(arr1, arr2);
        int[] res = find(arr, arr3);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    private int[] find(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int a = 0;
        int b = 0;

        while (a < arr1.length && b < arr2.length) {
            if (arr1[a] == arr2[b]) {
                list.add(arr1[a]);
                a++;
                b++;
                continue;
            }
            if (arr1[a] < arr2[b]) {
                a++;
                continue;
            }
            b++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        for (Integer i : new Number1213().arraysIntersection(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 7, 9}, new int[]{1, 3, 4, 5, 8})) {
            System.out.println(i);
        }
    }
}
