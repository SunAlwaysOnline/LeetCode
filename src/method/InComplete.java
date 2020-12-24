package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/12/24 15:53:32
 * 未完成
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InComplete {
}
