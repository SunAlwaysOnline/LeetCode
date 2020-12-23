package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/12/23 11:12:10
 * 自底向上(类似于后续遍历)
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DownTop {
}
