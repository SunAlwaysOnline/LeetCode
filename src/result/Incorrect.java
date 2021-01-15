package result;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/01/15 10:49:50
 * 不正确的
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Incorrect {
}
