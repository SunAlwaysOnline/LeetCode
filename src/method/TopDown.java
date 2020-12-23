package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/12/23 11:11:22
 * 自顶向下(类似于前序遍历)
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TopDown {
}
