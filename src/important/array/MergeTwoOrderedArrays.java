package important.array;

/**
 * @author qcy
 * @create 2021/05/18 09:17:35
 * 合并两个有序数组
 */
public class MergeTwoOrderedArrays {

    private int[] merge(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int[] ans = new int[aLength + bLength];
        int aIndex = 0;
        int bIndex = 0;
        int index = 0;

        while (index < ans.length) {
            if (aIndex == aLength) {
                ans[index++] = b[bIndex++];
                continue;
            }
            if (bIndex == bLength) {
                ans[index++] = a[aIndex++];
                continue;
            }
            if (a[aIndex] <= b[bIndex]) {
                ans[index++] = a[aIndex++];
            } else {
                ans[index++] = b[bIndex++];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] array = new MergeTwoOrderedArrays().merge(new int[]{1, 4, 9}, new int[]{2, 5, 8});
        for (int i : array) {
            System.out.println(i);
        }
    }
}
