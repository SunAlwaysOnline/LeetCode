package company.ths;

/**
 * @author qcy
 * @create 2021/07/01 17:15:20
 * 同花顺
 * <p>
 * 合并两个有序数组
 */
public class MergeTwoOrderArray {

    private int[] merge(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int length = aLength + bLength;

        int[] result = new int[length];
        int aIndex = 0;
        int bIndex = 0;
        int index = 0;

        while (aIndex < aLength || bIndex < bLength) {
            if (aIndex < aLength && bIndex < bLength) {
                if (a[aIndex] > b[bIndex]) {
                    result[index++] = b[bIndex++];
                } else {
                    result[index++] = a[aIndex++];
                }
                continue;
            }
            if (aIndex < aLength) {
                result[index++] = a[aIndex++];
                continue;
            }
            result[index++] = b[bIndex++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 8};
        int[] b = {0, 2, 9};
        int[] result = new MergeTwoOrderArray().merge(a, b);
        for (int i : result) {
            System.out.print(i);
        }
    }
}
