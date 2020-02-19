package top.mengtech.springboot_mybatis.interfaces;

import java.lang.annotation.*;

/**
 * 多数据源注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurDataSource {
    String name() default "first";
}
