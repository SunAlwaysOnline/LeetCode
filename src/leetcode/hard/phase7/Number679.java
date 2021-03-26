package leetcode.hard.phase7;

import method.Classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qcy
 * @create 2021/03/26 14:07:58
 * 679. 24 点游戏
 *
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 *
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，
 * 表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/24-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Classic
public class Number679 {
    public static final double distance = 0.000001;
    boolean can = false;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        cal(list);
        return can;
    }

    private void cal(List<Double> nums) {
        if (can) {
            return;
        }
        int size = nums.size();
        if (size == 2) {
            double a = nums.get(0);
            double b = nums.get(1);
            if (Math.abs(a + b - 24) < distance ||
                    Math.abs(a - b - 24) < distance ||
                    Math.abs(b - a - 24) < distance ||
                    Math.abs(a * b - 24) < distance ||
                    Math.abs(a / b - 24) < distance ||
                    Math.abs(b / a - 24) < distance) {
                can = true;
            }
            return;
        }
        //剩3个数
        if (size == 3) {
            for (int i = 0; i < 3; i++) {
                List<Double> needRemoveList = new ArrayList<>(nums);
                Double removeNum = needRemoveList.remove(i);
                List<Double> kinds = calTwoNum(needRemoveList.get(0), needRemoveList.get(1));
                for (Double kind : kinds) {
                    List<Double> list = new ArrayList<>();
                    list.add(removeNum);
                    list.add(kind);
                    cal(list);
                }
            }
            return;
        }
        //剩4个数
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                List<Double> needRemoveList = new ArrayList<>(nums);
                Double iNum = needRemoveList.remove(i);
                Double jNum = needRemoveList.remove(j - 1);
                List<Double> kinds = calTwoNum(iNum, jNum);
                for (Double kind : kinds) {
                    List<Double> list = new ArrayList<>();
                    list.add(kind);
                    list.add(needRemoveList.get(0));
                    list.add(needRemoveList.get(1));
                    cal(list);
                }
            }
        }
    }

    public List<Double> calTwoNum(double a, double b) {
        List<Double> values = new ArrayList<>();
        values.add(a + b);
        values.add(a - b);
        values.add(b - a);
        values.add(a * b);
        values.add(a / b);
        values.add(b / a);
        return values;
    }

    public static void main(String[] args) {
        System.out.println(new Number679().judgePoint24(new int[]{4, 1, 8, 7}));
    }

}
