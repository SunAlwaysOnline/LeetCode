package leetcode.medium.phase1;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;
import method.StringOperation;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qcy
 * @create 2021/02/12 19:49:27
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@StringOperation
public class Number49 {

    //n为数组的长度,K为每个字符串的长度
    @SpaceComplexity("O(nk)")
    @TimeComplexity("O(nklok)")
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sort = sort(s);
            List<String> in = map.get(sort);
            if (in == null) {
                in = new ArrayList<>();
            }
            in.add(s);
            map.put(sort, in);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
