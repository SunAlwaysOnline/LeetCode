package leetcode.medium.phase8;

import result.OverTime;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qcy
 * @create 2021/03/12 17:13:53
 * 767. 重构字符串
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number767 {

    char[] chars;
    int length;
    boolean[] use;
    boolean stop = false;
    String res;

    @OverTime
    public String reorganizeString1(String S) {
        chars = S.toCharArray();
        length = chars.length;
        use = new boolean[length];
        res = "";
        dfs(new StringBuilder());
        return res;
    }

    private void dfs(StringBuilder sb) {
        if (stop) {
            return;
        }
        if (sb.length() == length) {
            res = sb.toString();
            stop = true;
            return;
        }
        for (int i = 0; i < length; i++) {
            if (use[i]) {
                continue;
            }
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == chars[i]) {
                continue;
            }
            use[i] = true;
            sb.append(chars[i]);
            dfs(sb);
            use[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    //--------------------------------------------------------------
    public String reorganizeString(String S) {

        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            maxCount = Math.max(maxCount, count);
            map.put(c, count);
        }

        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }

        Queue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Character ch : map.keySet()) {
            queue.offer(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            Character a = queue.poll();
            Character b = queue.poll();
            sb.append(a).append(b);

            map.put(a, map.get(a) - 1);
            map.put(b, map.get(b) - 1);
            if (map.get(a) > 0) {
                queue.offer(a);
            }
            if (map.get(b) > 0) {
                queue.offer(b);
            }
        }
        if (queue.size() == 1) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number767().reorganizeString("aaabbbb"));
    }

}
