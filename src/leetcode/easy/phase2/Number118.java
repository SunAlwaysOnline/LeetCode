package leetcode.easy.phase2;

import method.Classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/01/16 23:04:02
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
@Classic
public class Number118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                //当为某行第一个数或是最后一个数时，都为1
                if (j == 0 || j == i) {
                    innerList.add(1);
                    //否则第i行的第j个数等于第i-1行第j个数加上第i-1行第j-1个数
                } else {
                    innerList.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
                }
            }
            //别忘了在外层list中添加内层list
            list.add(innerList);
        }
        return list;
    }

}
