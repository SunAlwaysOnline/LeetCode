package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/10/21 15:24:09
 * 字典
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Map {
}
