package top.mengtech.springboot_mybatis.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import top.mengtech.springboot_mybatis.config.DynamicDataSource;
import top.mengtech.springboot_mybatis.interfaces.CurDataSource;
import top.mengtech.springboot_mybatis.interfaces.DataSourceNames;

import java.lang.reflect.Method;

/**
 * @ClassName DataSourceAspect
 * @Description  多数据源，切面处理
 * @Author MQM
 * @Date 2020-02-19 15:05
 */

@Slf4j
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    @Override
    public int getOrder() {
        return 1;
    }

    @Pointcut("@annotation(top.mengtech.springboot_mybatis.interfaces.CurDataSource)")
    public void dataSourcePointCut(){

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        CurDataSource ds = method.getAnnotation(CurDataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
            log.debug("set datasource is " + DataSourceNames.FIRST);
        } else {
            DynamicDataSource.setDataSource(ds.name());
            log.debug("set datasource is " + ds.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            log.debug("clean datasource");
        }
    }
}
