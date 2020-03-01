package top.mengtech.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.mengtech.mybatis_plus.bean.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    void createUserTable(String tableName);
    List<String> selectTableWithShow(String tableName);
}
