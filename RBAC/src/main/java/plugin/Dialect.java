package plugin;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Properties;

/**
 * 数据库方言，针对不同数据库实现
 */
public interface Dialect {

    /**
     * 是否跳过count和分页
     * @param msId
     * @param parameterObject
     * @param rowBounds
     * @return
     */
    boolean skip(String msId, Object parameterObject, RowBounds rowBounds);

    /**
     * 是否进行count，true进行count，false则继续下面的beforePage
     * @param msId 执行的MyBatis方法全名
     * @param parameterObject
     * @param rowBounds
     * @return
     */
    boolean beforeCount(String msId,Object parameterObject,RowBounds rowBounds);

    /**
     * 生成查询count的sql
     * @param boundSql
     * @param parameterObject
     * @param rowBounds
     * @param cacheKey
     * @return
     */
    String getCountSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey cacheKey);

    /**
     * 获取count后
     * @param count 查询结果总数
     * @param parameterObject   接口参数
     * @param rowBounds 分页参数
     */
    void afterCount(long count,Object parameterObject,RowBounds rowBounds);

    /**
     * 执行分页前，返回true会进行分页，返回false会返回默认查询结果
     * @param msId
     * @param parameterObject
     * @param rowBounds
     * @return
     */
    boolean beforePage(String msId,Object parameterObject,RowBounds rowBounds);

    /**
     * 生成分页查询
     * @param boundSql  绑定sql对象
     * @param parameterObject   方法参数
     * @param rowBounds 分页参数
     * @param cacheKey  分页缓存key
     * @return
     */
    String getPageSql(BoundSql boundSql,Object parameterObject,RowBounds rowBounds,CacheKey cacheKey);

    /**
     * 分页查询后，处理分页结果，拦截器中直接return该方法的返回值
     * @param pageList
     * @param parameterObject
     * @param rowBounds
     * @return
     */
    Object afterPage(List pageList,Object parameterObject,RowBounds rowBounds);

    /**
     * 设置参数
     * @param properties    插件属性
     */
    void setProperties(Properties properties);
}
