package leetcode.medium.phase7;

import datastructure.Heap;
import method.Classic;

import java.util.*;

/**
 * @author qcy
 * @create 2021/03/12 14:39:30
 * 692. 前K个高频单词
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *  
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *  
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Heap
public class Number692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> queue = new PriorityQueue<>((a, b) -> {
            int aCount = map.get(a);
            int bCount = map.get(b);
            return aCount == bCount ? b.compareTo(a) : aCount - bCount;
        });

        for (String word : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(word);
                continue;
            }

            String peek = queue.peek();
            int peekCount = map.get(peek);
            int wordCount = map.get(word);
            if (peekCount < wordCount) {
                queue.poll();
                queue.offer(word);
                continue;
            }

            if (peekCount == wordCount && peek.compareTo(word) > 0) {
                queue.poll();
                queue.offer(word);
            }
        }

        String[] array = new String[k];
        while (!queue.isEmpty()) {
            array[--k] = queue.poll();
        }
        return Arrays.asList(array);
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        for (String s : new Number692().topKFrequent(words, 3)) {
            System.out.println(s);
        }
    }

}
