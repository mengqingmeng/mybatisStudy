package top.mengtech.springboot_mybatis.jwt;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName JwtRequest
 * @Description
 * @Author MQM
 * @Date 2020-02-16 18:30
 */

@Getter
@Setter
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = -3884131668473413269L;
    private String userName;
    private String password;
}
