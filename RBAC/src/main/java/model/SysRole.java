package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import type.Enabled;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class SysRole implements Serializable {

    private static final long serialVersionUID = 4204323001441919162L;

    private Long id;
    private String roleName;
    private Enabled enabled;
//    private Integer enabled;
    private String createBy;
    private Date createTime;

    private SysUser sysUser;

    List<SysPrivilege> privilegeList;
}
