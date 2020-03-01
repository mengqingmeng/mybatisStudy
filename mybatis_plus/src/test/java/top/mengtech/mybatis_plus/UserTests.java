package top.mengtech.mybatis_plus;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.mengtech.mybatis_plus.bean.User;
import top.mengtech.mybatis_plus.config.MyBatisPlusConfiguration;
import top.mengtech.mybatis_plus.mapper.UserMapper;

import java.util.List;

@Slf4j
@SpringBootTest
class UserTests {

    @Autowired private UserMapper userMapper;

    @Test
    void selectUser() {
        List<User> userList = userMapper.selectList(null);
        userList.stream().forEach(System.out::println);
    }

    @Test
    void testDynamicTable(){
        MyBatisPlusConfiguration.tableNameThreadLocal.set("user_001");
        List<User> userList = userMapper.selectList(null);
        userList.stream().forEach(System.out::println);
    }

    @Test
    void createTable(){
        userMapper.createUserTable("user_002");
    }

    @Test
    void checkTableExist(){
        List<String> strings = userMapper.selectTableWithShow("user");
        log.info(strings.toString());
    }
}
