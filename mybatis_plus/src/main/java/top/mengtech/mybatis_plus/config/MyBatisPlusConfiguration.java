package top.mengtech.mybatis_plus.config;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MyBatisPlusConfiguration {

    public static ThreadLocal<String> tableNameThreadLocal = new ThreadLocal<>();

    // 分页拦截器
    @Bean
    public PaginationInterceptor paginationInterceptor(){

        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        List<ISqlParser> sqlParserList = new ArrayList<>();

        // 动态表名
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();

        Map<String, ITableNameHandler> tableNameHandlerMap = new HashMap<>();
        tableNameHandlerMap.put("user", (metaObject, sql, tableName) -> tableNameThreadLocal.get());
        dynamicTableNameParser.setTableNameHandlerMap(tableNameHandlerMap);

        sqlParserList.add(dynamicTableNameParser);

        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }
}
