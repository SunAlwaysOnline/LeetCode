package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/01/26 10:58:08
 * 不是很理解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WaitForUnderstand {
}
