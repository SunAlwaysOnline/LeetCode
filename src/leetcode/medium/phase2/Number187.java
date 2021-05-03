package leetcode.medium.phase2;

import util.ListUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qcy
 * @create 2021/05/03 10:10:18
 * 187. 重复的DNA序列
 *
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，
 * 例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number187 {

    public List<String> findRepeatedDnaSequences(String s) {
        int size = s.length();
        if (size <= 10) {
            return new ArrayList<>();
        }

        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();

        for (int i = 0; i <= size - 10; i++) {
            String str = s.substring(i, i + 10);

            if (set.contains(str)) {
                ans.add(str);
            } else {
                set.add(str);
            }
        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        List<String> list = new Number187().findRepeatedDnaSequences("AAAAAAAAAAA");
        ListUtil.print(list);
    }

}
