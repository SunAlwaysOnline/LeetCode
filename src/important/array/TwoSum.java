package important.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qcy
 * @create 2021/05/15 22:23:55
 * 两数之和
 */
public class TwoSum {

    //Spring解决循环依赖时,比如A依赖B,B依赖A
    //则在实例化A后,将A放入map中.之后准备依赖注入时,发现需要B
    //转而去实例化B,将B放入map中.之后准备依赖注入时,发现需要A,直接从map中取到A,B的属性注入完成
    //最后回到A的属性注入,从map中取到B,完成A的属性注入.至此,解决循环依赖
    //当然,Spring解决循环依赖,根本上利用的是三级缓存.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] array = new TwoSum().twoSum(new int[]{2, 7, 9, 11}, 9);
        for (int i : array) {
            System.out.println(i);
        }
    }

}
