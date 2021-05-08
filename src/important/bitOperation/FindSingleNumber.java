package important.bitOperation;

import method.BitOperation;

/**
 * @author qcy
 * @create 2021/05/08 14:41:41
 * 找出只出现一次的数字
 */
@BitOperation
public class FindSingleNumber {

    //a^b^c^b^c=a^(b^b)^(c^c)=a^1^1=a;
    //0^a=a
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }

}
