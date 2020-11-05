package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/11/05 09:26:40
 * 广度优先遍历 Breath First Search
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BFS {
}
