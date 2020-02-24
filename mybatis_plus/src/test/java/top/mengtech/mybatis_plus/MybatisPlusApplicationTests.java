package top.mengtech.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.mengtech.mybatis_plus.bean.User;
import top.mengtech.mybatis_plus.dao.UserMapper;

import java.util.*;

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

    @Test
    public void selectByQueryMapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("avg(age) age_avg","email","name")
                .groupBy("email","name").having("age_avg>{0}",20);
        List<Map<String,Object>> usersMap = userMapper.selectMaps(queryWrapper);

    }

    @Test
    public void selectPage(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",19);

        Page<User> page = new Page<>(1,2);
        IPage<User> iPage = userMapper.selectPage(page,queryWrapper);
        System.out.println("total:" + iPage.getTotal());
        System.out.println("pages:" + iPage.getPages());
        List<User> records = iPage.getRecords();
        records.stream().forEach(System.out::println);
    }

}
