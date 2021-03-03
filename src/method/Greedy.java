package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/03/03 15:37:08
 * 贪心算法
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Greedy {
}
