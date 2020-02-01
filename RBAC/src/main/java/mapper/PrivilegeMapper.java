package mapper;

import model.SysPrivilege;

import java.util.List;

public interface PrivilegeMapper {
    List<SysPrivilege> selectPrivilegesByRoleId(Long roleId);
}
