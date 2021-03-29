package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/03/29 21:29:02
 * 记忆化递归
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MemDP {
}
