package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/11/03 09:59:06
 * 一开始的想法(一般是暴力的,或者是不成熟的)
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Orignal {
}
