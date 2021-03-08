package leetcode.medium.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import datastructure.BinaryTree;
import method.Classic;
import method.Maths;

/**
 * @author qcy
 * @create 2021/03/08 14:12:54
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@BinaryTree
@Maths
public class Number96 {

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n^2)")
    //f(n)表示以n个结点构造出来的bst的个数
    //f(0)=1(空树也是一种情况)
    //f(1)=1
    //f(2)=2
    //假设有3个结点，分别为1,2,3
    //以1为树根,左边有0个结点，右边有2个结点，共f(0)*f(2)种
    //以2为树根,左边有1个结点，右边有1个结点，共f(1)*f(1)种
    //以3为树根,左边有2个结点，右边有0个结点，共f(2)*f(0)种
    //f(3)=f(0)*f(2)+f(1)*f(1)+f(2)*f(0);
    //则f(n)=f(0)*f(n-1)+f(1)*f(n-2)+f(2)*f(n-2)+....+f(n-1)*f(0);
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;

        //f(2)=f(0)*f(1)+f(1)*f(0)
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j] * f[i - j - 1];
            }
        }

        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(new Number96().numTrees(13));
    }

}
