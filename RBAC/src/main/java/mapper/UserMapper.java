package mapper;

import model.SysUser;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    SysUser selectById(Long id);
}
