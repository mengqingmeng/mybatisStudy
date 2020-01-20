package model;

import lombok.Getter;
import lombok.Setter;
import type.Enabled;

import java.util.Date;

@Setter
@Getter
public class SysRole {
    private Long id;
    private String roleName;
//    private Enabled enabled;
    private Integer enabled;
    private String createBy;
    private Date createTime;

    private SysUser sysUser;
}
