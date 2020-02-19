package top.mengtech.springboot_mybatis.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import top.mengtech.springboot_mybatis.interfaces.DataSourceNames;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DynamicDataSourceConfig
 * @Description
 * @Author MQM
 * @Date 2020-02-19 14:17
 */

@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.first")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.second")
    public DataSource secondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource,DataSource secondDataSource){
        Map<Object,Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.FIRST,firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND,secondDataSource);

        return new DynamicDataSource(firstDataSource,targetDataSources);
    }
}
