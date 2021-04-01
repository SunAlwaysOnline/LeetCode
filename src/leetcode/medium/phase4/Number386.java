package leetcode.medium.phase4;

import datastructure.BinaryTree;
import method.Classic;
import util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/04/01 10:26:19
 * 386. 字典序排数
 *
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
public class Number386 {

    List<Integer> list = new ArrayList<>();
    int n;

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        for (int i = 1; i <= 9; i++) {
            dfs(i);
        }
        return list;
    }

    private void dfs(int i) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            dfs(i * 10 + j);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new Number386().lexicalOrder(101);
        ListUtil.print(list);
    }
}
