package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/09/30 11:42:38
 * 滑动窗口
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SlidingWindow {
}
