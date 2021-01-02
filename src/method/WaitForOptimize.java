package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/12/14 11:02:02
 * 还有更加优化的做法
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WaitForOptimize {
}
