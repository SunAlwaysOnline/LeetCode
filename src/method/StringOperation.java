package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/01/14 09:55:15
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StringOperation {
}
