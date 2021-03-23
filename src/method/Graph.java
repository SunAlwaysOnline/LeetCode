package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/03/23 09:14:56
 * 图
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Graph {
}
