package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysRolePrivilege {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long privilegeId;
}
