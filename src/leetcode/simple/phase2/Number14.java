package leetcode.simple.phase2;

/**
 * @author qcy
 * @create 2020/10/02 11:33:42
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class Number14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        //取出数组中元素的最小长度
        int min = Integer.MAX_VALUE;
        for (String temp : strs) {
            int len = temp.length();
            if (len < min) {
                min = len;
            }
        }

        StringBuilder sb = new StringBuilder();
        //对应位置上的字符是否相等的标记，默认相等，当某一次比较中不相等的话，退出所有循环
        boolean flag = true;
        for (int i = 0; i < min&&flag; i++) {
            char s = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (s != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
