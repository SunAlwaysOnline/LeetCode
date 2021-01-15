package leetcode.medium.phase5;

import method.WaitForComplete;
import result.Incorrect;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author qcy
 * @create 2021/01/15 10:32:39
 */
@WaitForComplete
@Incorrect
public class Number470 {

    class SolBase {
        public int rand7() {
            return new Random().nextInt(7) + 1;
        }
    }

    class Solution extends SolBase {
        public int rand10() {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += rand7();
            }
            return sum / 7;
        }
    }

    public static void main(String[] args) {
        Number470 number470 = new Number470();
        Solution solution = number470.new Solution();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int rand = solution.rand10();
            map.put(rand, map.getOrDefault(rand, 0) + 1);
        }
        System.out.println();
    }

}
