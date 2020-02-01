package mapper;

import model.SysRole;

import java.util.List;

public interface RoleMapper {
    List<SysRole> selectAllRoleAndPrivileges();
    List<SysRole> selectRolesByUserId(Long userId);
    SysRole selectRoleById(Long roleId);
    int updateRoleById(SysRole sysRole);
}
