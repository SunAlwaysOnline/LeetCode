package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/10/15 20:09:56
 * 迭代
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Iteration {
}
