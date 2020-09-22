package medium.phase1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/09/21 20:00:34
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Number77 {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return result;
    }

    //dfs表示从start开始，在1-n中选k个数
    public void dfs(int n, int k, int start) {
        //终止条件,当找到k个数时,立即返回
        if (path.size() == k) {
            //将当前包含k个数的路径加入到结果集中
            result.add(new ArrayList<>(path));
            return;
        }

        //从起始元素开始寻找,终止元素都是n
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            //将当前找到的数放进路径中
            path.add(i);
            //开始进入下一层中
            dfs(n, k, i + 1);
            //当dfs返回时,代表已经找到了k个数,则返回上一层继续寻找,因此需要移除路径末尾的元素
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        List<List<Integer>> combine = new Number77().combine(n, k);
        System.out.println(combine);
    }
}
