package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/09/28 14:52:26
 * 并查集
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UF {
}
