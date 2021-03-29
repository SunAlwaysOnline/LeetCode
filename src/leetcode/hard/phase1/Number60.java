package leetcode.hard.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;
import method.PermutationAndCombination;
import method.Prune;
import method.Violence;
import result.OverTime;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/03/29 09:38:52
 * 60. 排列序列
 *
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 3
 * 输出："213"
 * 示例 2：
 *
 * 输入：n = 4, k = 9
 * 输出："2314"
 * 示例 3：
 *
 * 输入：n = 3, k = 1
 * 输出："123"
 *  
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number60 {
    List<String> list = new ArrayList<>();
    int n1;
    boolean[] used1;

    @Violence
    @OverTime
    public String getPermutation1(int n, int k) {
        this.n1 = n;
        used1 = new boolean[n + 1];
        dfs1(new StringBuilder());
        return list.get(k - 1);
    }

    private void dfs1(StringBuilder sb) {
        if (sb.length() == n1) {
            list.add(sb.toString());
            return;
        }
        for (int i = 1; i <= n1; i++) {
            if (used1[i]) {
                continue;
            }
            used1[i] = true;
            sb.append(i);
            dfs1(sb);
            sb.deleteCharAt(sb.length() - 1);
            used1[i] = false;
        }
    }

    //------------------------------------
    int n;
    int k;
    boolean[] used;
    int[] factorial;

    @Prune
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n^2)")
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        used = new boolean[n + 1];
        factorial = new int[10];
        calFactorial();
        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        return sb.toString();
    }

    //index为当前需要确定的字符串的下标
    private void dfs(int index, StringBuilder sb) {
        if (index == n) {
            return;
        }

        //剩余数字的组合总数
        int count = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (count < k) {
                k -= count;
                continue;
            }
            used[i] = true;
            sb.append(i);
            dfs(index + 1, sb);
            return;
        }
    }

    private void calFactorial() {
        factorial[0] = 1;
        for (int i = 1; i <= 9; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number60().getPermutation(3, 3));
    }
}
