package interview.easy.phase1;

import method.Classic;
import method.DoublePointer;
import method.InPlace;
import method.StringOperation;

/**
 * @author qcy
 * @create 2021/03/27 22:28:09
 * 面试题 01.03. URL化
 *
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *  
 *
 * 示例 1：
 *
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例 2：
 *
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 *  
 *
 * 提示：
 *
 * 字符串长度在 [0, 500000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
@StringOperation
public class Number01dot03 {

    @InPlace
    @DoublePointer
    public String replaceSpaces(String S, int length) {
        //待填充的下标
        int fillIndex = S.length() - 1;
        char[] chars = S.toCharArray();
        //遍历的下标
        int index = length - 1;

        while (index >= 0) {
            if (chars[index] != ' ') {
                chars[fillIndex] = chars[index];
                fillIndex--;
                index--;
                continue;
            }
            chars[fillIndex] = '0';
            chars[fillIndex - 1] = '2';
            chars[fillIndex - 2] = '%';
            fillIndex -= 3;
            index--;
        }

        return new String(chars).substring(fillIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Number01dot03().replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }
}
