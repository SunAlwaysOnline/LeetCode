package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/12/09 16:41:15
 * 经典题(高频)
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Classic {
}
