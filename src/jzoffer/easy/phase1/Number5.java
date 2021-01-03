package jzoffer.easy.phase1;

/**
 * @author qcy
 * @create 2021/01/03 19:53:50
 * 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 */
public class Number5 {

    public String replaceSpace(String s) {
        //return s.replaceAll(" ", "%20");
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a b cd";
        System.out.println(new Number5().replaceSpace(s));
    }

}
