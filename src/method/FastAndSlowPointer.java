package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/10/10 14:42:52
 * 快慢指针
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FastAndSlowPointer {
}
