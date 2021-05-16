package important.sort;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;

/**
 * @author qcy
 * @create 2021/05/16 21:28:36
 */
public class BubblingSort {

    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n^2)")
    //稳定排序,相同大小的数,一开始排在前面,最终还是排在前面
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        //一共需要length-1趟
        //每一趟把当前的最大元素放在未排序部分的尾部
        for (int i = 0; i < length - 1; i++) {
            boolean isSort = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSort = true;
                }
            }
            if (!isSort) {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = new BubblingSort().sortArray(new int[]{3, 9, 5, 1, 8});
        for (int i : array) {
            System.out.println(i);
        }
    }

}
