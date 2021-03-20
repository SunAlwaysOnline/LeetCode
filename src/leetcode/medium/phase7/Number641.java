package leetcode.medium.phase7;

import datastructure.LinkedList;
import method.Classic;
import method.Design;

/**
 * @author qcy
 * @create 2021/03/15 09:53:49
 * 641. 设计循环双端队列
 *
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *   
 *
 * 提示：
 *
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Design
@LinkedList
public class Number641 {

    class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    class MyCircularDeque {
        //容量
        int capacity;
        //当前大小
        int size;
        Node head;
        Node tail;

        public MyCircularDeque(int k) {
            capacity = k;
            size = 0;
            head = null;
            tail = null;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            Node node = new Node(value);
            if (head == null && tail == null) {
                head = node;
                tail = node;
                size++;
                return true;
            }
            head.pre = node;
            node.next = head;
            head = node;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            Node node = new Node(value);
            if (head == null && tail == null) {
                head = node;
                tail = node;
                size++;
                return true;
            }
            node.pre = tail;
            tail.next = node;
            tail = node;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            if (head == tail) {
                head = null;
                tail = null;
                size--;
                return true;
            }
            Node headNext = head.next;
            head.next = null;
            headNext.pre = null;
            head = headNext;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            if (head == tail) {
                head = null;
                tail = null;
                size--;
                return true;
            }
            Node tailPre = tail.pre;
            tail.pre = null;
            tailPre.next = null;
            tail = tailPre;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return head.val;
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return tail.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

}
