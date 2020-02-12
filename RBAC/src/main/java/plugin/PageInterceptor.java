package plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * @ClassName PageInterceptor
 * @Description
 * @Author MQM
 * @Date 2020-02-11 16:53
 */

@Intercepts(@Signature(type = Executor.class,method="query",args={MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}))
public class PageInterceptor implements Interceptor {
    private Dialect dialect;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 参数
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameterObject = args[1];
        RowBounds rowBounds = (RowBounds) args[2];

        // 不跳过count和分页
        if(!dialect.skip(mappedStatement.getId(),parameterObject,rowBounds)){
            ResultHandler resultHandler = (ResultHandler) args[3];
            Executor executor = (Executor) invocation.getTarget();
            mappedStatement.getBoundSql(parameterObject);
        }

        return invocation.proceed();
    }
}
