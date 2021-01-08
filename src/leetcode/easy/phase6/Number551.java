package leetcode.easy.phase6;

/**
 * @author qcy
 * @create 2021/01/08 14:21:20
 * 551. 学生出勤记录 I
 *
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 示例 1:
 *
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 *
 * 输入: "PPALLL"
 * 输出: False
 *
 */
public class Number551 {

    public boolean checkRecord(String s) {
        char[] array = s.toCharArray();
        int aCount = 0;
        int repeatL = 0;
        for (char ch : array) {
            if (ch == 'L') {
                if (repeatL == 2) {
                    return false;
                }
                repeatL++;
                continue;
            }
            if (ch == 'A') {
                if (aCount > 0) {
                    return false;
                }
                aCount++;
            }
            repeatL = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number551().checkRecord("LLAL"));
    }
}
