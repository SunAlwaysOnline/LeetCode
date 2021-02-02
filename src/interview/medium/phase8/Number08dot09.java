package interview.medium.phase8;

import method.Classic;
import method.PermutationAndCombination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/02/02 10:30:46
 * 面试题 08.09. 括号
 *
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@PermutationAndCombination
public class Number08dot09 {

    List<String> list = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(n, n, "");
        return list;
    }

    private void dfs(int leftRemain, int rightRemain, String s) {
        if (s.length() == 2 * n) {
            list.add(s);
            return;
        }
        if (leftRemain > 0) {
            dfs(leftRemain - 1, rightRemain, s + "(");
        }
        if (rightRemain > leftRemain) {
            dfs(leftRemain, rightRemain - 1, s + ")");
        }
    }

    public static void main(String[] args) {
        for (String s : new Number08dot09().generateParenthesis(2)) {
            System.out.println(s);
        }
    }

}
