package leetcode.medium.phase3;

import datastructure.Trie;
import method.Classic;
import method.Design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2020/12/16 14:31:42
 * 208. 实现 Trie (前缀树)
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 */
@Design
@Classic
@Trie
public class Number208 {

    class TrieNode {
        boolean isEnd;
        Map<Character, TrieNode> links;

        public TrieNode() {
            isEnd = false;
            links = new HashMap<>();
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char curChar : word.toCharArray()) {
                if (!node.links.containsKey(curChar)) {
                    node.links.put(curChar, new TrieNode());
                }
                node = node.links.get(curChar);
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (char curChar : prefix.toCharArray()) {
                if (!node.links.containsKey(curChar)) {
                    return null;
                }
                node = node.links.get(curChar);
            }
            return node;
        }
    }

    public static void main(String[] args) {
        Number208 main = new Number208();

        Trie trie = main.new Trie();
        System.out.println(trie.search("a"));
        trie.insert("abc");
        System.out.println(trie.startsWith("ab"));
        trie.insert("ade");
        System.out.println(trie.search("ade"));
    }
}
