package exception;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/01/11 09:32:49
 * 数值溢出
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NumericOverflow {
}
