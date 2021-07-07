package company.didi;

/**
 * @author qcy
 * @create 2021/07/06 20:28:58
 * 选择排序
 */
public class SelectSort {

    private void sort(int[] nums) {

        //当前有序数组的左边元素的下标
        int sortedIndex = nums.length;

        while (sortedIndex > 0) {
            int max = nums[0];
            int maxIndex = 0;

            for (int i = 0; i < sortedIndex; i++) {
                if (nums[i] >= max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }

            //交换无序数组中的当前数与有序数组的左边的数
            swap(maxIndex, --sortedIndex, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 1, 5, 7};
        new SelectSort().sort(array);
        for (int i : array) {
            System.out.print(i);
        }
    }
}
