package leetcode.medium.phase6;

import datastructure.Grid;
import method.Classic;

/**
 * @author qcy
 * @create 2021/02/10 20:41:28
 * 531. 孤独像素 I
 *
 * 给定一幅黑白像素组成的图像, 计算黑色孤独像素的数量。
 *
 * 图像由一个由‘B’和‘W’组成二维字符数组表示, ‘B’和‘W’分别代表黑色像素和白色像素。
 *
 * 黑色孤独像素指的是在同一行和同一列不存在其他黑色像素的黑色像素。
 *
 * 示例:
 *
 * 输入:
 * [['W', 'W', 'B'],
 *  ['W', 'B', 'W'],
 *  ['B', 'W', 'W']]
 *
 * 输出: 3
 * 解析: 全部三个'B'都是黑色孤独像素。
 *  
 *
 * 注意:
 *
 * 输入二维数组行和列的范围是 [1,500]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lonely-pixel-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Grid
public class Number531 {

    public int findLonelyPixel(char[][] picture) {
        int row = picture.length;
        int col = picture[0].length;

        int[] rowSum = new int[row];
        int[] colSum = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (picture[i][j] == 'B') {
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (picture[i][j] == 'B' && rowSum[i] == 1 && colSum[j] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        char[][] picture = {
                {'B', 'W', 'W', 'W', 'W', 'B', 'W', 'B', 'B', 'W'},
                {'B', 'B', 'B', 'W', 'W', 'W', 'B', 'W', 'B', 'W'},
                {'B', 'B', 'B', 'B', 'W', 'W', 'W', 'B', 'W', 'W'},
                {'B', 'W', 'W', 'B', 'W', 'B', 'B', 'W', 'W', 'W'},
                {'W', 'W', 'B', 'W', 'B', 'B', 'B', 'W', 'B', 'B'},
                {'W', 'B', 'B', 'W', 'W', 'W', 'B', 'W', 'W', 'W'},
                {'B', 'W', 'W', 'B', 'B', 'B', 'W', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'B', 'B', 'B', 'B', 'W', 'W', 'W'},
                {'W', 'W', 'B', 'B', 'W', 'W', 'W', 'W', 'B', 'W'},
                {'W', 'W', 'W', 'B', 'B', 'B', 'W', 'W', 'W', 'B'}
        };
        int sum = new Number531().findLonelyPixel(picture);
        System.out.println(sum);
    }
}
