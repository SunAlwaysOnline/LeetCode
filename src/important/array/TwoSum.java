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

        //2依赖7,7依赖2
        //一开始2找不到7,为了防止接下来的数字依赖2,则先把2放入到map中
        //7找到2,则直接找到答案
        //本质上都是,A依赖B,找不到B的话,则先把自己放入到map中
        //当接下来的B找到A时,可以将B也放入到A,防止之后或之前的对象依赖于B
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
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
