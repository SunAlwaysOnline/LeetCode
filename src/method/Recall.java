package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/09/23 13:58:27
 * 回溯
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Recall {
}
