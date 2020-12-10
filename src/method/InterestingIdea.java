package method;

import java.lang.annotation.*;

/**
 * @author qcy
 * @create 2020/12/10 13:53:04
 * 有趣的想法
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InterestingIdea {
}
