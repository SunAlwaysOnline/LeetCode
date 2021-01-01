package interview.medium.phase17;

import method.BitOperation;
import method.Classic;

/**
 * @author qcy
 * @create 2021/01/01 20:29:03
 * 面试题 16.01. 交换数字
 *
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * 提示：
 *
 * numbers.length == 2
 *
 */
@Classic
public class Number16dot01 {

    //(1,2)->(2,1)
    public int[] swapNumbers1(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    //不用加减法
    @BitOperation
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2};
        for (int i : new Number16dot01().swapNumbers(numbers)) {
            System.out.println(i);
        }
    }

}
