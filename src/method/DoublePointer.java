package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/10/16 15:25:56
 * 双指针
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DoublePointer {
}
