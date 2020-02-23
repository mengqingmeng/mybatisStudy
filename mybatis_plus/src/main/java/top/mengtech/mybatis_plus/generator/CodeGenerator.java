package top.mengtech.mybatis_plus.generator;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;

import java.util.Scanner;

/**
 * @ClassName CodeGenerator
 * @Description
 * @Author MQM
 * @Date 2020-02-22 17:27
 */

public class CodeGenerator {

    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("请输入 "+tip + " :");
        System.out.println(sb.toString());
        if (scanner.hasNext()){
            String in = scanner.next();
            if(StringUtils.isNotBlank(in)){
                return in;
            }
        }
        throw new RuntimeException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 生成器
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setAuthor("MQM");
        globalConfig.setOpen(false);
        generator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatis_plus");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        generator.setDataSource(dataSourceConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(scanner("模块名"));
        packageConfig.setParent("top.mengtech.mybatis_plus");

    }
}
