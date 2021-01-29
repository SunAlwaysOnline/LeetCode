package leetcode.medium.phase3;

import method.Design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qcy
 * @create 2021/01/29 13:48:37
 * 281. 锯齿迭代器
 *
 * 给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。
 *
 * 示例:
 *
 * 输入:
 * v1 = [1,2]
 * v2 = [3,4,5,6]
 *
 * 输出: [1,3,2,4,5,6]
 *
 * 解析: 通过连续调用 next 函数直到 hasNext 函数返回 false，
 *      next 函数返回值的次序应依次为: [1,3,2,4,5,6]。
 * 拓展：假如给你 k 个一维向量呢？你的代码在这种情况下的扩展性又会如何呢?
 *
 * 拓展声明：
 *  “锯齿” 顺序对于 k > 2 的情况定义可能会有些歧义。
 * 所以，假如你觉得 “锯齿” 这个表述不妥，也可以认为这是一种 “循环”。例如：
 *
 * 输入:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 *
 * 输出: [1,4,8,2,5,9,3,6,7].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Design
public class Number281 {

    public class ZigzagIterator {
        List<List<Integer>> lists;
        int size;
        int cur;
        List<Integer> indexList;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            lists = new ArrayList<>();
            lists.add(v1);
            lists.add(v2);
            size = lists.size();
            cur = 0;

            indexList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                indexList.add(0);
            }
        }

        public int next() {
            int res = lists.get(cur).get(indexList.get(cur));
            indexList.set(cur, indexList.get(cur) + 1);
            cur = (cur + 1) % size;
            return res;
        }


        public boolean hasNext() {
            int start = cur;
            while (indexList.get(cur) == lists.get(cur).size()) {
                cur = (cur + 1) % size;
                if (start == cur) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(5, 6, 7);
        Number281 number281 = new Number281();
        ZigzagIterator zigzagIterator = number281.new ZigzagIterator(list1, list2);
        while (zigzagIterator.hasNext()) {
            System.out.println(zigzagIterator.next());
        }

    }

}
