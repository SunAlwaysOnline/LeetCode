package simple.phase1;

import java.util.Arrays;

/**
 * @author qcy
 * @create 2020/09/21 16:14:35
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Number88 {

    //创建一个新的数组复制nums1
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = nums1[i];
        }
        //数组1的下标
        int index1 = 0;
        //数组2的下标
        int index2 = 0;
        //新数组的下标
        int newIndex = 0;
        while (newIndex < m && index2 < n) {
            nums1[index1++] = array[newIndex] < nums2[index2] ? array[newIndex++] : nums2[index2++];
        }
        //如果此时array还有剩余的数，则直接添加进nums1中
        for (int i = newIndex; i < m; i++) {
            nums1[index1++] = array[i];
        }
        //如果此时nums2还有剩余的数，则直接添加进nums1中
        for (int i = index2; i < n; i++) {
            nums1[index1++] = nums2[i];
        }
    }

    //不开辟新的数组空间，直接在原数组上操作
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //原nums1最后一个元素下标
        int index1 = m - 1;
        //nums2最后一个元素下标
        int index2 = n - 1;
        //整合后的nums1最后一个元素下标
        int index = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            nums1[index--] = nums1[index1] < nums2[index2] ? nums2[index2--] : nums1[index1--];
        }

        //如果index1＜0,说明原nums1上的数已经全部填到整合后的nums1中了,那么按照顺序将nums2中剩余的数填入即可
        for (int i = index2; i >= 0; i--) {
            nums1[index--] = nums2[i];
        }
        //如果index2<0,说明nums2上的数已经全部填到整合后的nums1中了，而原nums1上的数本来就在整合后的nums1上，因此这里不需要做任何操作
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 6, 10, 0, 0, 0};
        int[] nums2 = {20, 40, 90};
        new Number88().merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(System.out::println);
    }
    
}

