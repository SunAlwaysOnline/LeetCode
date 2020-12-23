package leetcode.easy.phase10;

import method.Orignal;
import method.WaitForOptimize;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/12/23 17:02:22
 * 997. 找到小镇的法官
 *
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 *
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * 示例 3：
 *
 * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * 示例 4：
 *
 * 输入：N = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 * 示例 5：
 *
 * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] 是完全不同的
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 */
public class Number997 {

    @Orignal
    @WaitForOptimize
    public int findJudge(int N, int[][] trust) {
        if (trust == null || trust.length == 0) {
            if (N == 1) {
                return 1;
            }
            return -1;
        }
        //(某个人,被信任的次数)
        Map<Integer, Integer> countMap = new HashMap<>();
        //编号为index+1的人是否信任别人,0信任,1不信任
        int[] array = new int[N];

        for (int i = 0; i < trust.length; i++) {
            array[trust[i][0] - 1] = 1;
            countMap.put(trust[i][1], countMap.getOrDefault(trust[i][1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == N - 1) {
                if (array[entry.getKey() - 1] == 0) {
                    return entry.getKey();
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(new Number997().findJudge(4, trust));
    }

}
