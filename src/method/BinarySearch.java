package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/11/11 09:32:36
 * 二分查找
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BinarySearch {
}
