package company.boss;

import java.util.*;

/**
 * @author qcy
 * @create 2021/06/30 21:04:30
 * <p>
 * 合并k个有序数组
 */
public class MergeArray {

    private int[] merge(List<int[]> arrays) {
        int m = arrays.size();
        //计算结果集大小
        int length = 0;
        for (int[] array : arrays) {
            length += array.length;
        }
        int[] result = new int[length];
        int resultIndex = 0;

        //每个数组当前所处的下标
        int[] index = new int[m];

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{arrays.get(i)[0], i});
        }

        while (resultIndex < length) {
            int[] poll = queue.poll();
            result[resultIndex++] = poll[0];
            System.out.println(poll[0]);

            //第几个数组
            int mIndex = poll[1];
            //所在的数组
            int[] array = arrays.get(mIndex);

            //当前数组的下一个数
            if (array.length - 1 == index[mIndex]) {
                continue;
            }
            int next = array[++index[mIndex]];
            queue.offer(new int[]{next, mIndex});
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3, 4};
        int[] a2 = new int[]{2, 3, 8};
        int[] a3 = new int[]{0, 1, 7};

        List<int[]> arrays = new ArrayList<>();
        arrays.add(a1);
        arrays.add(a2);
        arrays.add(a3);

        int[] result = new MergeArray().merge(arrays);
        for (int i : result) {
            System.out.print(i);
        }
    }
}
