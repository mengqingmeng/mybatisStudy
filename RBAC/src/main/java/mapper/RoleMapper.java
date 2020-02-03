package mapper;

import model.SysRole;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;

import java.util.List;

@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {
    List<SysRole> selectAllRoleAndPrivileges();
    List<SysRole> selectRolesByUserId(Long userId);
    SysRole selectRoleById(Long roleId);
    int updateRoleById(SysRole sysRole);
}
