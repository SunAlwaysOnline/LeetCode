package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2021/03/03 11:29:29
 * 前缀和
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PrefixSum {
}
