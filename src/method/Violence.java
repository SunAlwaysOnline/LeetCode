package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/10/16 15:45:07
 * 暴力解法
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Violence {
}
