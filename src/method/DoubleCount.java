package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/12/23 11:35:38
 * 重复计算
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DoubleCount {
}
