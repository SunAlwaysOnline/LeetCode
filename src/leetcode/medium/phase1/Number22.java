package leetcode.medium.phase1;

import method.Classic;
import method.PermutationAndCombination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/02/03 13:41:21
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number22 {

    List<String> list = new ArrayList<>();
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(n, n, "");
        return list;
    }

    private void dfs(int leftRemain, int rigthRemain, String s) {
        if (s.length() == 2 * n) {
            list.add(s);
        }
        if (leftRemain > 0) {
            dfs(leftRemain - 1, rigthRemain, s + "(");
        }
        if (rigthRemain > leftRemain) {
            dfs(leftRemain, rigthRemain - 1, s + ")");
        }
    }

}
