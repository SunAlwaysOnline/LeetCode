package important.sort;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;

/**
 * @author qcy
 * @create 2021/06/22 10:52:59
 */
public class MergeSort {

    //稳定排序,基于分而治之的思想
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(nlogn)")
    private void sort(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];
        sort(nums, 0, nums.length - 1, temp);
    }

    private void sort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        sort(nums, left, middle, temp);
        sort(nums, middle + 1, right, temp);
        merge(nums, left, right, temp);
    }

    //left左边界，right右边界
    private void merge(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int tempIndex = 0;
        int middle = (left + right) / 2;
        int i = left;
        int j = middle + 1;

        while (i <= middle || j <= right) {
            if (i <= middle && j <= right) {
                if (nums[i] < nums[j]) {
                    temp[tempIndex++] = nums[i];
                    i++;
                } else {
                    temp[tempIndex++] = nums[j];
                    j++;
                }
                continue;
            }
            if (i <= middle) {
                temp[tempIndex++] = nums[i];
                i++;
                continue;
            }
            if (j <= right) {
                temp[tempIndex++] = nums[j];
                j++;
            }
        }

        tempIndex = 0;
        while (left <= right) {
            nums[left++] = temp[tempIndex++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 8, 1, 9, 2, 6, 0};
        new MergeSort().sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
