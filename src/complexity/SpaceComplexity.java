package complexity;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/11/10 11:33:19
 * 空间复杂度
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SpaceComplexity {
    String value();
}
