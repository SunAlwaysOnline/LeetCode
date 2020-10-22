package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/10/22 09:32:09
 * 找规律
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FindRule {
}
