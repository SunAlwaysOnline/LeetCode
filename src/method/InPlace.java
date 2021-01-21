package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/01/21 10:01:28
 * 原地操作
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InPlace {
}
