package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/10/22 11:15:06
 * 字符串操作
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrOperation {
}
