package important.array;

/**
 * @author qcy
 * @create 2021/06/06 21:10:03
 * 搜索旋转排序数组
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 */
public class SearchRotationSortArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            }

            if (midNum >= nums[left]) {
                //[left,mid]内有序
                if (target >= nums[left] && target <= midNum) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                //[mid,right]内有序
                if (target >= midNum && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
