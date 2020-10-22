package leetcode.simple.phase6;

/**
 * @author qcy
 * @create 2020/10/22 10:50:08
 * 557. 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Number557 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] array = s.split(" ");
        for (String str : array) {
            char[] ch = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                ch[i] = str.charAt(str.length() - i - 1);
            }
            sb.append(new String(ch) + " ");
        }

        return sb.toString().substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Number557().reverseWords(s));
    }

}
