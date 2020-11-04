package leetcode.easy.phase8;

/**
 * @author qcy
 * @create 2020/10/08 21:15:10
 * 706. 设计哈希映射
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希映射
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * <p>
 * 示例：
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 */

public class Number706 {

    static class MyHashMap {
        Node[] table;
        int size;

        class Node {
            public int key;
            public int value;
            public Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public MyHashMap() {
            table = new Node[8];
        }

        public Node[] resize() {
            int oldLength = table.length;
            Node[] newTable = new Node[oldLength * 2];
            size = 0;

            for (Node value : table) {
                Node node = value;
                while (node != null) {
                    put(node.key, node.value, newTable);
                    node = node.next;
                }
            }

            return table = newTable;
        }

        public void put(int key, int value, Node[] curTable) {
            Node node = curTable[key % curTable.length];

            if (node == null) {
                if (++size == curTable.length) {
                    curTable = resize();
                }
                curTable[key % curTable.length] = new Node(key, value);
                size++;
                return;
            }

            while (true) {
                if (key == node.key) {
                    node.value = value;
                    return;
                }
                if (node.next == null) {
                    node.next = new Node(key, value);
                    return;
                }
                node = node.next;
            }
        }

        public void put(int key, int value) {
            put(key, value, table);
        }

        public int get(int key) {
            Node node = table[key % table.length];
            if (node == null) {
                return -1;
            }

            while (true) {
                if (node.key == key) {
                    return node.value;
                }
                node = node.next;
                if (node == null) {
                    return -1;
                }
            }
        }

        public void remove(int key) {
            int index = key % table.length;
            Node node = table[index];

            if (node == null) {
                return;
            }

            if (node.key == key) {
                table[index] = node.next;
                size--;
                return;
            }

            while (true) {
                if (node == null) {
                    return;
                }
                Node nextNode = node.next;
                if (nextNode == null) {
                    return;
                }
                if (nextNode.key == key) {
                    node.next = nextNode.next;
                    nextNode.next = null;
                    nextNode = null;
                    return;
                }
                node = node.next;
            }

        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));// 返回 1
        System.out.println(hashMap.get(3)); // 返回 -1 (未找到)
        hashMap.put(2, 1);  // 更新已有的值
        System.out.println(hashMap.get(2)); // 返回 1
        hashMap.remove(2);  // 删除键为2的数据
        System.out.println(hashMap.get(2)); // 返回 -1 (未找到)

        hashMap.put(3, 3);
        hashMap.put(4, 4);
        hashMap.put(5, 5);
        hashMap.put(6, 6);
        hashMap.put(7, 7);
        hashMap.put(8, 8);
        hashMap.remove(7);
        hashMap.put(5, 3);
        System.out.println(hashMap.get(8));
        System.out.println(hashMap.get(5));


    }
}
