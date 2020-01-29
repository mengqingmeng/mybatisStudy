package mapper;

import model.SysRole;
import model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    SysUser selectById(Long id);
    List<SysUser> selectAll();
    List<SysRole> selectRolesByUserId(Long userId);
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId")Long userId,@Param("enabled")Integer enabled);
    int insertUser(SysUser user);
    int updateByUserId(SysUser user);
    SysUser selectUserRoleById(Long userId);
    SysUser selectUserRoleById2(Long userId);
}
