package result;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/12/18 09:41:35
 * 超时
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OverTime {
}
