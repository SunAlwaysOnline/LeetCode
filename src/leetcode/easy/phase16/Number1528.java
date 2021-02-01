package leetcode.easy.phase16;

import datastructure.Array;
import method.Classic;
import method.InPlace;

/**
 * @author qcy
 * @create 2021/02/01 11:28:00
 * 1528. 重新排列字符串
 *
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 *
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 *
 * 返回重新排列后的字符串。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * 输出："leetcode"
 * 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 * 示例 2：
 *
 * 输入：s = "abc", indices = [0,1,2]
 * 输出："abc"
 * 解释：重新排列后，每个字符都还留在原来的位置上。
 * 示例 3：
 *
 * 输入：s = "aiohn", indices = [3,1,4,2,0]
 * 输出："nihao"
 * 示例 4：
 *
 * 输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 * 输出："arigatou"
 * 示例 5：
 *
 * 输入：s = "art", indices = [1,0,2]
 * 输出："rat"
 *  
 *
 * 提示：
 *
 * s.length == indices.length == n
 * 1 <= n <= 100
 * s 仅包含小写英文字母。
 * 0 <= indices[i] < n
 * indices 的所有的值都是唯一的（也就是说，indices 是整数 0 到 n - 1 形成的一组排列）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@Array
public class Number1528 {

    public String restoreString1(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] res = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = chars[i];
        }
        return new String(res);
    }

    @InPlace
    public String restoreString2(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            int j = i;
            while (indices[j] > 0 && indices[j] != i) {
                swap(chars, i, indices[j]);
                indices[j] = -indices[j];    // 负数表示indices[j]处的元素已经是最终结果
                j = -indices[j];    // 记录当前i位置元素的原下标
            }
        }
        return new String(chars);
    }

    @InPlace
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            if (i == indices[i]) {
                continue;
            }
            while (i != indices[i]) {
                int temp = indices[i];
                swap(indices, i, temp);
                swap(chars, i, temp);
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        //s = "codeleet", indices = [4,5,6,7,0,2,1,3]
        System.out.println(new Number1528().restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        //s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
        System.out.println(new Number1528().restoreString("aaiougrt", new int[]{4, 0, 2, 6, 7, 3, 1, 5}));
    }

}
