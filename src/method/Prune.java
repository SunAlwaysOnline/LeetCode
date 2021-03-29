package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/03/29 10:25:51
 * 剪枝
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Prune {
}
