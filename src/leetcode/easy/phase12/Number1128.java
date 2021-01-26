package leetcode.easy.phase12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/01/26 09:19:35
 * 1128. 等价多米诺骨牌对的数量
 *
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *  
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < dominoes.length; i++) {
            String key = dominoes[i][0] > dominoes[i][1] ?
                    dominoes[i][0] + "" + dominoes[i][1] : dominoes[i][1] + "" + dominoes[i][0];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val == 1) {
                continue;
            }
            sum += val * (val - 1) / 2;
        }
        return sum;
    }

}
