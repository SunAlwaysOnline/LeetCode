package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/11/09 17:30:14
 * 目前最优解法
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Optimal {
}
