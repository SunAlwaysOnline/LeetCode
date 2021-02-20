package leetcode.easy.phase3;

/**
 * @author qcy
 * @create 2021/02/20 11:31:21
 * 246. 中心对称数
 *
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 *
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 *
 *
 * 示例 1:
 *
 * 输入: num = "69"
 * 输出: true
 * 示例 2:
 *
 * 输入: num = "88"
 * 输出: true
 * 示例 3:
 *
 * 输入: num = "962"
 * 输出: false
 * 示例 4：
 *
 * 输入：num = "1"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number246 {

    public boolean isStrobogrammatic(String num) {
        int length = num.length();

        for (int i = 0; i < (length + 1) / 2; i++) {
            char ch = num.charAt(i);
            char dh = num.charAt(length - i - 1);
            boolean flag = (ch == '1' || ch == '8' || ch == '6' || ch == '9' || ch == '0');
            if (!flag) {
                return false;
            }
            if (ch == '6' && dh != '9') {
                return false;
            }
            if (ch == '9' && dh != '6') {
                return false;
            }
            if (ch == '1' && dh != '1') {
                return false;
            }
            if (ch == '0' && dh != '0') {
                return false;
            }
            if (ch == '8' && dh != '8') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number246().isStrobogrammatic("88"));
    }

}
