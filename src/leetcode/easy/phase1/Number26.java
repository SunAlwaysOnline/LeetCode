package leetcode.easy.phase1;

/**
 * @author qcy
 * @create 2020/10/27 09:59:32
 * 26. 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class Number26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }

        int newLength = length;
        int curIndex = 0;
        int curNum = nums[curIndex];

        while (++curIndex < newLength) {
            if (curNum == nums[curIndex]) {
                for (int i = curIndex; i < newLength - 1; i++) {
                    nums[i] = nums[i + 1];
                }
                newLength--;
                curIndex--;
            } else {
                curNum = nums[curIndex];
            }
        }

        return newLength;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 3, 4};
        System.out.println(new Number26().removeDuplicates1(nums));
    }
}
