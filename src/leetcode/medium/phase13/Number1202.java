package leetcode.medium.phase13;

import method.Classic;
import method.UF;

import java.util.*;

/**
 * @author qcy
 * @create 2021/03/11 15:13:35
 * 1202. 交换字符串中的元素
 *
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * 
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@UF
public class Number1202 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();
        UF uf = new UF(length);
        for (List<Integer> list : pairs) {
            uf.union(list.get(0), list.get(1));
        }

        Map<Integer, Integer> parentMap = new HashMap<>();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int parent = uf.findParent(i);
            parentMap.put(i, parent);
            map.computeIfAbsent(parent, v -> new PriorityQueue<Character>()).offer(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int parent = parentMap.get(i);
            PriorityQueue<Character> queue = map.get(parent);
            sb.append(queue.poll());
        }

        return sb.toString();
    }

    class UF {
        int n;
        int[] parent;

        public UF(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int findParent(int i) {
            if (parent[i] != i) {
                parent[i] = findParent(parent[parent[i]]);
            }
            return parent[i];
        }

        private void union(int a, int b) {
            int aParent = findParent(a);
            int bParent = findParent(b);
            if (aParent == bParent) {
                return;
            }
            parent[aParent] = bParent;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> out = new ArrayList<>();
        out.add(Arrays.asList(0, 3));
        out.add(Arrays.asList(1, 2));
        String s = new Number1202().smallestStringWithSwaps("dcab", out);
        System.out.println(s);
    }

}
