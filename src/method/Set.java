package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/11/09 17:29:06
 * 去重或者检测是否存在重复
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Set {
}
