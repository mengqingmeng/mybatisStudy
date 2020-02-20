package top.mengtech.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.mengtech.mybatis_plus.bean.User;

public interface UserMapper extends BaseMapper<User> {
}
