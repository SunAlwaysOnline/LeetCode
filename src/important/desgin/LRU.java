package important.desgin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/05/28 15:46:50
 * LRU缓存机制
 */
public class LRU {

    static class LRUCache {

        //最近使用的key,放入到链表尾部
        LinkedList<Integer> list;
        Map<Integer, Integer> map;
        int capacity;

        public LRUCache(int capacity) {
            list = new LinkedList<>();
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            list.remove(new Integer(key));
            list.addLast(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            //如果key不存在
            if (!map.containsKey(key)) {
                if (map.size() < capacity) {
                    map.put(key, value);
                    list.addLast(key);
                } else {
                    //已经满了
                    Integer first = list.removeFirst();
                    map.remove(first);
                    map.put(key, value);
                    list.addLast(key);
                }
            } else {
                //key存在
                map.put(key, value);
                list.remove(new Integer(key));
                list.addLast(key);
            }
        }
    }

    //泛型
    static class LRUCache2<K, V> {

        LinkedList<K> list;
        Map<K, V> map;
        int capacity;

        public LRUCache2(int capacity) {
            list = new LinkedList<>();
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public V get(K key) {
            if (!map.containsKey(key)) {
                return null;
            }
            list.remove(key);
            list.addLast(key);
            return map.get(key);
        }

        public void put(K key, V value) {
            //如果key不存在
            if (!map.containsKey(key)) {
                if (map.size() < capacity) {
                    map.put(key, value);
                    list.addLast(key);
                } else {
                    //已经满了
                    K first = list.removeFirst();
                    map.remove(first);
                    map.put(key, value);
                    list.addLast(key);
                }
            } else {
                //key存在
                map.put(key, value);
                list.remove(key);
                list.addLast(key);
            }
        }
    }

    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
//        cache.put(3, 3);
//        System.out.println(cache.get(2));

        LRUCache2<Integer, Integer> cache2 = new LRUCache2<>(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        System.out.println(cache2.get(1));
        cache2.put(3, 3);
        System.out.println(cache2.get(2));
    }
}
