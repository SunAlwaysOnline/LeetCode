package leetcode.medium.phase2;

import method.Classic;
import method.Design;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author qcy
 * @create 2020/12/14 16:17:34
 * 146. LRU 缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 *
 */
@Design
@Classic
public class Number146 {

    static class LRUCache {

        LinkedList<Integer> list;
        HashMap<Integer, Integer> map;
        int size;

        public LRUCache(int capacity) {
            list = new LinkedList<>();
            map = new HashMap<>();
            size = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            //删除旧位置的key,并移动到list尾部,保证头部是最近最久未使用的元素
            list.remove(new Integer(key));
            list.offer(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            //修改元素的值
            if (map.containsKey(key)) {
                map.put(key, value);
                list.remove(new Integer(key));
                list.add(key);
                return;
            }
            //插入新元素
            map.put(key, value);
            if (list.size() == size) {
                //移除头部元素
                Integer first = list.removeFirst();
                map.remove(first);
            }
            list.add(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }


}
