package important.array;

import complexity.SpaceComplexity;
import complexity.TimeComplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qcy
 * @create 2021/06/13 18:08:05
 */
public class ThreeSum {

    @SpaceComplexity("O(logn)")
    @TimeComplexity("O(n^2)")
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return out;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                return out;
            }
            //保证下一轮在第一个数上不会重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    out.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //继续往后面找
                    //需要避免重复
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return out;
    }

}

