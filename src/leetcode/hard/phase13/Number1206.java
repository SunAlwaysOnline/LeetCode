package leetcode.hard.phase13;

import datastructure.SkipList;
import method.Design;
import method.WaitForComplete;

/**
 * @author qcy
 * @create 2021/03/30 21:00:35
 */
@Design
@SkipList
@WaitForComplete
public class Number1206 {

    class Skiplist {
        //向上提拔的概率
        private static final double CHANCE = 0.25;
        //最大层数
        private static final int MAX_LEVEL = 16;

        class Node {
            Integer val;
            //当前结点在不同层的下一节点
            Node[] next;
            //当前结点所在的最大层
            int level;

            public Node(Integer val, int level) {
                this.val = val;
                this.level = level;
                next = new Node[level];
            }
        }

        //头结点
        Node head = new Node(null, MAX_LEVEL - 1);
        //当前最大层数
        int curMaxLevel = 1;

        public Skiplist() {

        }

        public boolean search(int target) {
            return false;
        }

        public void add(int num) {

        }

        public boolean erase(int num) {
            return false;
        }

        //获得随机层数
        private int getRandomLevel() {
            int level = 1;
            while (level < MAX_LEVEL && Math.random() < CHANCE) {
                level++;
            }
            return level;
        }
    }

}
