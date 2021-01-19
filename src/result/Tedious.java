package result;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/01/19 10:32:13
 * 代码写得繁琐
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Tedious {
}
