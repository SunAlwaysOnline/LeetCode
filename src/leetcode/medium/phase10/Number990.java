package leetcode.medium.phase10;

import method.Classic;
import method.UF;

/**
 * @author qcy
 * @create 2021/03/12 09:31:04
 * 990. 等式方程的可满足性
 *
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
 * 并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@UF
public class Number990 {

    public boolean equationsPossible(String[] equations) {
        UF uf = new UF();
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                continue;
            }
            Character[] element = getElement(equation);
            uf.union(element[0] - 97, element[2] - 97);
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                continue;
            }
            Character[] element = getElement(equation);
            int aParent = uf.findParent(element[0] - 97);
            int bParent = uf.findParent(element[2] - 97);
            if (aParent == bParent) {
                return false;
            }
        }
        return true;
    }

    private Character[] getElement(String equation) {
        Character[] res = new Character[3];
        res[0] = equation.charAt(0);
        res[1] = equation.charAt(1);
        res[2] = equation.charAt(3);
        return res;
    }

    class UF {
        int[] parent;

        public UF() {
            parent = new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        private int findParent(int i) {
            while (parent[i] != i) {
                i = parent[i];
            }
            return i;
        }

        private void union(int a, int b) {
            int aParent = findParent(a);
            int bParent = findParent(b);
            if (aParent == bParent) {
                return;
            }
            parent[aParent] = bParent;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number990().equationsPossible(new String[]{"a==b", "b!=c", "a==c"}));
    }

}
