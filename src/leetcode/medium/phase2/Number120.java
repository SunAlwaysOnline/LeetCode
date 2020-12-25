package leetcode.medium.phase2;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;
import method.Classic;
import method.WaitForOptimize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2020/12/25 10:54:09
 * 120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *  
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 */
@Classic
@WaitForOptimize
public class Number120 {

    @SpaceComplexity("O(1)")
    @TimeComplexity("O(n)")
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        for (int i = 0; i < triangle.size(); i++) {
            if (i == 0) {
                continue;
            }
            //当前行
            List<Integer> row = triangle.get(i);
            //上一行
            List<Integer> preRow = triangle.get(i - 1);

            for (int j = 0; j < row.size(); j++) {

                //第一列
                if (j == 0) {
                    row.set(0, preRow.get(0) + row.get(0));
                    continue;
                }
                //最后一列
                if (j == row.size() - 1) {
                    row.set(row.size() - 1, preRow.get(preRow.size() - 1) + row.get(row.size() - 1));
                    continue;
                }
                //其他列
                int minVal = Math.min(preRow.get(j - 1), preRow.get(j));
                row.set(j, minVal + row.get(j));
            }
        }

        int res = Integer.MAX_VALUE;
        List<Integer> list = triangle.get(triangle.size() - 1);
        for (Integer num : list) {
            res = Math.min(res, num);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);

        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);

        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        out.add(l1);
        out.add(l2);
        out.add(l3);
        out.add(l4);

        System.out.println(new Number120().minimumTotal(out));

    }
}
