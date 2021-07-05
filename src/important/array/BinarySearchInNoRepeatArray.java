package important.array;

/**
 * @author qcy
 * @create 2021/07/05 14:09:06
 * 不重复的有序数组中的二分查找
 */
public class BinarySearchInNoRepeatArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(new BinarySearchInNoRepeatArray().search(array, 13));
    }

}
