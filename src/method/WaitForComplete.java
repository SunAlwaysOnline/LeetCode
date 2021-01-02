package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/01/02 20:53:05
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WaitForComplete {
}
