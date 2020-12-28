package leetcode.medium.phase3;

import method.Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author qcy
 * @create 2020/12/28 15:26:58
 * 284. 顶端迭代器
 *
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器
 * 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 *
 * 示例:
 *
 * 假设迭代器被初始化为列表 [1,2,3]。
 *
 * 调用 next() 返回 1，得到列表中的第一个元素。
 * 现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
 * 最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
 * 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
 *
 */
@Design
public class Number284 {

    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iterator;
        private Integer advance;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
        }

        public Integer peek() {
            if (advance != null) {
                return advance;
            }
            if (!hasNext()) {
                return null;
            }
            advance = iterator.next();
            return advance;
        }

        @Override
        public Integer next() {
            if (advance != null) {
                Integer res = advance;
                advance = null;
                return res;
            }
            if (!hasNext()) {
                return null;
            }
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            if (advance != null) {
                return true;
            }
            return iterator.hasNext();
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        Number284 number284 = new Number284();
        PeekingIterator peekingIterator = number284.new PeekingIterator(iterator);
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }
}
