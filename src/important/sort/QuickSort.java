package important.sort;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author qcy
 * @create 2021/05/13 15:47:17
 * 快速排序
 * 原理: https://blog.csdn.net/weixin_42437295/article/details/90771962
 * 优化: https://mp.weixin.qq.com/s/eczDPHzUm_BZ_8zrywhFTQ
 */
public class QuickSort {

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    //快速排序的每一轮处理其实就是将这一轮的基准数归位，当所有的基准数归位，排序就结束
    //主要思想：分治
    //空间复杂度取决于递归的深度，相当于二分查找
    //时间复杂度：首先需要进行logn趟，每趟需要比较n个数，因此为nlogn
    //为不稳定排序
    @SpaceComplexity("O(logn)")
    @TimeComplexity("O(nlogn)")
    public void sort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }

        //以最左边的数为基准数
        int base = nums[left];
        int i = left;
        int j = right;

        while (i < j) {
            //j从右往左，找到一个比base小的数
            while (i < j && nums[j] >= base) {
                j--;
            }
            //i从左往右，找到一个比base大的数
            while (i < j && nums[i] <= base) {
                i++;
            }
            //交换这两个数
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        //基准数归位
        nums[left] = nums[i];
        nums[i] = base;

        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int[] array = new QuickSort().sortArray(new int[]{4, 7, 3, 1, 8});
        String collect = Arrays.stream(array).boxed().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }

}
