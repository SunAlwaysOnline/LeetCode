package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/09/23 14:57:53
 * 深度优先搜索
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DFS {
}
