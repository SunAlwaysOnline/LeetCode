package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/10/21 15:19:19
 * 排序
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Sort {
    //排序方式
    //quick 快速排序
    //heap 堆排序
    //merge 归并排序
    String way() default "sort";
}
