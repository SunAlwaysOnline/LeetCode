package leetcode.easy.phase12;

/**
 * @author qcy
 * @create 2021/02/05 11:14:06
 * 1134. 阿姆斯特朗数
 *
 * 假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
 *
 * 给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
 * 
 *
 * 示例 1：
 *
 * 输入：153
 * 输出：true
 * 示例：
 * 153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
 * 示例 2：
 *
 * 输入：123
 * 输出：false
 * 解释：
 * 123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/armstrong-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1134 {

    public boolean isArmstrong(int N) {
        int sum = 0;
        int length = String.valueOf(N).length();
        int n = N;
        for (int i = 0; i < length; i++) {
            sum += Math.pow(n % 10, length);
            n /= 10;
        }
        return sum == N;
    }

    public static void main(String[] args) {
        System.out.println(new Number1134().isArmstrong(153));
    }

}
