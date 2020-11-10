package complexity;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/11/10 11:32:23
 * 时间复杂度
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeComplexity {
    String value();
}
