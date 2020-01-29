package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import type.Enabled;

import java.util.Date;

@Setter
@Getter
@ToString
public class SysRole {
    private Long id;
    private String roleName;
//    private Enabled enabled;
    private Integer enabled;
    private String createBy;
    private Date createTime;

    private SysUser sysUser;
}
