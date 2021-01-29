package interview.medium.phase16;

import datastructure.Grid;
import method.Classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/01/29 11:05:57
 * 面试题 16.19. 水域大小
 *
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 *
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
public class Number16dot19 {

    //输入：
    //[
    //  [0,2,1,0],
    //  [0,1,0,1],
    //  [1,1,0,1],
    //  [0,1,0,1]
    //]
    //输出： [1,2,4]
    List<Integer> list = new ArrayList<>();

    public int[] pondSizes(int[][] land) {
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    int sum = dfs(land, i, j);
                    list.add(sum);
                }
            }
        }
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(int[][] land, int i, int j) {
        //超出边界
        if (i < 0 || i == land.length || j < 0 || j == land[0].length) {
            return 0;
        }
        //山
        if (land[i][j] > 0) {
            return 0;
        }
        int sum = 0;
        //水
        if (land[i][j] == 0) {
            sum++;
        }
        land[i][j] = 1;

        int top = dfs(land, i - 1, j);
        int bottom = dfs(land, i + 1, j);
        int left = dfs(land, i, j - 1);
        int right = dfs(land, i, j + 1);
        int topLeft = dfs(land, i - 1, j - 1);
        int topRight = dfs(land, i + 1, j - 1);
        int bottomLeft = dfs(land, i - 1, j + 1);
        int bottomRight = dfs(land, i + 1, j + 1);
        return sum + top + bottom + left + right + topLeft + topRight + bottomLeft + bottomRight;
    }


}
