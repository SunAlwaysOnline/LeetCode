package leetcode.simple.phase11;

import leetcode.simple.phase2.Number160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qcy
 * @create 2020/10/14 11:20:02
 *
 * 1002. 查找常用字符
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 */
public class Number1002 {

    public List<String> commonChars(String[] A) {
        if (A == null) {
            return null;
        }
        if (A.length == 1) {
            return Arrays.asList(A);
        }

        List<String> result = new ArrayList<>();

        int[] countArray = new int[26];
        Arrays.fill(countArray, 100);
        for (String a : A) {
            int[] temp = new int[26];
            char[] chars = a.toCharArray();
            for (char c : chars) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < temp.length; i++) {
                countArray[i] = Math.min(countArray[i], temp[i]);
            }
        }

        for (int i = 0; i < countArray.length; i++) {
            int count = countArray[i];
            String s = String.valueOf((char) (i + 'a'));
            while (count-- > 0) {
                result.add(s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] A = {"hello", "llbno", "lolmo"};
        new Number1002().commonChars(A).forEach(System.out::println);
    }
}
