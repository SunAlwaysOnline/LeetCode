package leetcode.medium.phase13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qcy
 * @create 2021/04/16 17:49:18
 * 1262. 可被三整除的最大和
 *
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-sum-divisible-by-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1262 {

    public int maxSumDivThree(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                a.add(num);
            } else if (num % 3 == 2) {
                b.add(num);
            }
        }

        if (sum % 3 == 0) {
            return sum;
        }

        Collections.sort(a);
        Collections.sort(b);

        int ans = 0;
        if (sum % 3 == 1) {
            if (a.size() >= 1) {
                ans = Math.max(ans, sum - a.get(0));
            }
            if (b.size() >= 2) {
                ans = Math.max(ans, sum - b.get(0) - b.get(1));
            }
        } else if (sum % 3 == 2) {
            if (b.size() >= 1) {
                ans = Math.max(ans, sum - b.get(0));
            }
            if (a.size() >= 2) {
                ans = Math.max(ans, sum - a.get(0) - a.get(1));
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Number1262().maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
    }

}
