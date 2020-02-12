package plugin;

import com.mysql.cj.result.Row;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Properties;

/**
 * @ClassName MySqlDialect
 * @Description
 * @Author MQM
 * @Date 2020-02-12 13:11
 */

public class MySqlDialect implements Dialect {
    @Override
    public boolean skip(String msId, Object parameterObject, RowBounds rowBounds) {
        // 是否跳过count和分页查询
        // 只要不等于RowBounds.DEFAULT都不跳过
        if (rowBounds != RowBounds.DEFAULT){
            return false;
        }
        return true;
    }

    @Override
    public boolean beforeCount(String msId, Object parameterObject, RowBounds rowBounds) {
        // rowBounds是PageRowBounds的实例才进行查询数量
        if (rowBounds instanceof PageRowBounds){
            return true;
        }
        return false;
    }

    @Override
    public String getCountSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey cacheKey) {
        return "select count(*) from (" + boundSql.getSql() + ") temp";
    }

    @Override
    public void afterCount(long count, Object parameterObject, RowBounds rowBounds) {
        ((PageRowBounds)rowBounds).setTotal(count);
    }

    @Override
    public boolean beforePage(String msId, Object parameterObject, RowBounds rowBounds) {
        if(rowBounds != RowBounds.DEFAULT) return true;
        return false;
    }

    @Override
    public String getPageSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey cacheKey) {
        // cacheKey 会影响缓存，通过固定的可以保证二级缓存有效
        cacheKey.update("RowBounds");

        return boundSql.getSql() + " limit " + rowBounds.getOffset() + "," + rowBounds.getLimit();
    }

    @Override
    public Object afterPage(List pageList, Object parameterObject, RowBounds rowBounds) {
        return pageList;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
