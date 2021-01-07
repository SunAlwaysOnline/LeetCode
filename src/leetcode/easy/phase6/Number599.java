package leetcode.easy.phase6;

import method.Optimal;
import method.Orignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/01/07 13:50:21
 * 599. 两个列表的最小索引总和
 *
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。
 * 你可以假设总是存在一个答案。
 *
 * 示例 1:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 *
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 *
 */
public class Number599 {

    @Orignal
    public String[] findRestaurant1(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        if (list1[0].equals(list2[0])) {
            res.add(list1[0]);
            return res.toArray(new String[0]);
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int j = 0; j < list2.length; j++) {
            String key = list2[j];
            Integer val = map.get(key);

            if (val == null) {
                continue;
            }
            map.put(key, (val + j) * -1);
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val >= 0) {
                continue;
            }
            min = Math.min(min, val * -1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val == min * -1) {
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[0]);
    }

    @Optimal
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minSumIndex = 2000;
        for (int j = 0; j < list2.length; j++) {
            if (!map.containsKey(list2[j])) {
                continue;
            }
            int i = map.get(list2[j]);
            if (i + j < minSumIndex) {
                res.clear();
                res.add(list2[j]);
                minSumIndex = i + j;
                continue;
            }
            if (i + j == minSumIndex) {
                res.add(list2[j]);
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = {"a", "b",};
        String[] list2 = {"x", "v", "r", "b"};
        for (String s : new Number599().findRestaurant(list1, list2)) {
            System.out.println(s);
        }
    }

}
