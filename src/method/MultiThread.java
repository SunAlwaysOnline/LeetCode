package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/04/21 09:23:35
 * 多线程
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MultiThread {
}
