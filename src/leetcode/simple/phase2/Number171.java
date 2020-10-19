package leetcode.simple.phase2;

/**
 * @author qcy
 * @create 2020/10/19 10:37:45
 * 171. Excel表列序号
 * <p>
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * AZ -> 52
 * BA -> 53
 * BB -> 54
 * ZY -> 701
 * ZZ -> 702
 * AAA-> 703
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 */
public class Number171 {

    public int titleToNumber(String s) {
        int result = 0;
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int power = length - i - 1;
            int multi = (int) ch - 64;
            result += Math.pow(26, power) * multi;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number171().titleToNumber("AAA"));
    }
}
