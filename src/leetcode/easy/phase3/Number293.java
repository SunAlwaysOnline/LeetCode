package leetcode.easy.phase3;

import method.StringOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qcy
 * @create 2021/02/10 19:37:08
 * 293. 翻转游戏
 *
 * 你和朋友玩一个叫做「翻转游戏」的游戏，
 * 游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。
 * 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
 *
 * 请你写出一个函数，来计算出第一次翻转后，字符串所有的可能状态。
 *  
 *
 * 示例：
 *
 * 输入: s = "++++"
 * 输出:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 * 注意：如果不存在可能的有效操作，请返回一个空列表 []。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@StringOperation
public class Number293 {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        boolean pre = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                if (pre) {
                    char[] copy = Arrays.copyOf(chars, chars.length);
                    copy[i - 1] = '-';
                    copy[i] = '-';
                    list.add(new String(copy));
                }
                pre = true;
            } else {
                pre = false;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        for (String s : new Number293().generatePossibleNextMoves("++++")) {
            System.out.println(s);
        }
    }

}
