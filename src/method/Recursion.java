package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/10/15 20:09:34
 * 递归
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Recursion {
}
