package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/04/13 16:45:52
 * 记忆化
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Mem {
}
