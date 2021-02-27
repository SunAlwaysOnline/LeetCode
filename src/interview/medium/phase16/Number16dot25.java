package interview.medium.phase16;

import method.Classic;
import method.Design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/02/25 10:00:41
 * 面试题 16.25. LRU 缓存
 *
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。
 * 缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。
 * 当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 );
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
@Classic
@Design
public class Number16dot25 {

    static class LRUCache {

        Map<Integer, Integer> map;
        //越靠近队列尾部，代表最近经常使用
        LinkedList<Integer> list;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            //移动到队列尾部
            list.remove(new Integer(key));
            list.offer(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                list.remove(new Integer(key));
            } else {
                //需要新增元素
                if (list.size() == capacity) {
                    //缓存满,则删除队列头部元素
                    Integer first = list.removeFirst();
                    map.remove(first);
                }
            }
            map.put(key, value);
            list.offer(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }

}
