package top.mengtech.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.mengtech.mybatis_plus.bean.User;
import top.mengtech.mybatis_plus.dao.UserMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect(){
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByIds(){
        List<Long> ids = Arrays.asList(1L,2L);

        List<User> userList = userMapper.selectBatchIds(ids);
    }

    @Test
    public void selectByMap(){
        // map的key为表中的列名，不是实体字段名
        Map<String,Object> map = new HashMap<>();
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);
    }

    @Test
    public void selectByWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","Ja").lt("age",20);
        List<User> users = userMapper.selectList(queryWrapper);
    }

}
