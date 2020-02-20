package top.mengtech.springboot_mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName FirstDataSourceConfiguration
 * @Description
 * @Author MQM
 * @Date 2020-02-20 9:01
 */

@Configuration
@MapperScan(basePackages = "top.mengtech.springboot_mybatis.mapper.first", sqlSessionTemplateRef  = "firstSqlSessionTemplate")
public class FirstDataSourceConfiguration {

    @Bean(name="firstDataSource")
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/first/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="firstTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("firstDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "firstSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
