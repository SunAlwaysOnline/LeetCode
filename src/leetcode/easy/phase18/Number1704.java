package leetcode.easy.phase18;

import method.StringOperation;

/**
 * @author qcy
 * @create 2021/02/03 14:46:05
 * 1704. 判断字符串的两半是否相似
 *
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 *
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。
 * 注意，s 可能同时含有大写和小写字母。
 *
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * 
 *
 * 示例 1：
 *
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 *
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 * 示例 3：
 *
 * 输入：s = "MerryChristmas"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "AbCdEfGh"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 2 <= s.length <= 1000
 * s.length 是偶数
 * s 由 大写和小写 字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/determine-if-string-halves-are-alike
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@StringOperation
public class Number1704 {

    public boolean halvesAreAlike(String s) {
        return count(s.substring(0, s.length() / 2)) == count(s.substring(s.length() / 2));
    }

    private int count(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "AbCdEfGh";
        System.out.println(new Number1704().halvesAreAlike(s));
    }

}