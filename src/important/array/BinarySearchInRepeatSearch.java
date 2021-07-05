package important.array;

/**
 * @author qcy
 * @create 2021/07/05 14:31:12
 * 重复的有序数组中的二分查找
 */
public class BinarySearchInRepeatSearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                while (mid > 0 && nums[mid - 1] == nums[mid]) {
                    mid--;
                }
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
