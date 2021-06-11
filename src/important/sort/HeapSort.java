package important.sort;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;

/**
 * @author qcy
 * @create 2021/06/11 15:46:03
 * 堆排序
 */
public class HeapSort {

    //不稳定排序
    @SpaceComplexity("O(1)")
    @TimeComplexity("O(nlogn)")
    private void sort(int[] nums) {

        //从最后一个非叶子节点开始,从下到上,从右到左进行调整
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int j = nums.length - 1; j > 0; j--) {
            //交换堆顶与末尾元素
            swap(nums, 0, j);
            //重新对堆进行调整
            adjustHeap(nums, 0, j);
        }

    }

    //该方法调整前length个数字构成的堆,从下标i处开始调整
    private void adjustHeap(int[] nums, int index, int length) {
        int temp = nums[index];
        //从index的左子节点开始
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            //如果有右子节点,且右子节点大于左子节点时
            if (i + 1 < length && nums[i] < nums[i + 1]) {
                //定位到右子节点
                i++;
            }
            //如果父节点比子节点都大
            if (temp > nums[i]) {
                break;
            }
            nums[index] = nums[i];
            index = i;
        }
        nums[index] = temp;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 8, 5, 1, 0, 4};
        new HeapSort().sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
