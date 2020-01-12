package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysPrivilege {
    /**
     * 权限ID
     */
    private Long id;
    /**
     * 权限名称
     */
    private String privilegeName;
    /**
     * 权限URL
     */
    private String privilegeUrl;
}
