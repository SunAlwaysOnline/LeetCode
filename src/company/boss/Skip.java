package company.boss;

/**
 * @author qcy
 * @create 2021/07/05 20:53:20
 * 跳跃游戏-跳到终点的最少次数
 */
public class Skip {

    private boolean canSkipSuccess(int[] array) {
        //能前往的最远下标
        int furthest = 0;

        for (int i = 0; i < array.length; i++) {
            if (i > furthest) {
                return false;
            }
            furthest = Math.max(furthest, i + array[i]);
            if (furthest >= array.length - 1) {
                return true;
            }
        }

        return false;
    }

    private int minTime(int[] array) {
        if (!canSkipSuccess(array)) {
            return 0;
        }
        int step = 0;
        int furthest = 0;
        int border = 0;

        for (int i = 0; i < array.length - 1; i++) {
            furthest = Math.max(furthest, i + array[i]);
            if (i == border) {
                border = furthest;
                step++;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 1, 4};
        System.out.println(new Skip().minTime(array));
    }
}
