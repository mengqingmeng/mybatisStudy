package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SysUser {
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] headImg;
    private Date createTime;
}
