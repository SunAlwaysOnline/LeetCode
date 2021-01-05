package leetcode.easy.phase6;

import java.util.*;

/**
 * @author qcy
 * @create 2021/01/05 10:12:50
 * 500. 键盘行
 *
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
 *
 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *  
 *
 * 注意：
 *
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 *
 */
public class Number500 {

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            boolean check = check(word);
            if (check) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }

    private boolean check(String word) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);

        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);

        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);

        int flag = -1;
        for (char ch : word.toCharArray()) {
            if (ch < 97) {
                ch = (char) (ch + 'a' - 'A');
            }
            Integer row = map.get(ch);
            if (flag == -1) {
                flag = row;
                continue;
            }
            if (flag != row) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        Arrays.stream(new Number500().findWords(words)).forEach(System.out::println);
    }

}
