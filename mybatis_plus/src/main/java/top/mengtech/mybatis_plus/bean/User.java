package top.mengtech.mybatis_plus.bean;

import lombok.Data;

/**
 * @ClassName User
 * @Description
 * @Author MQM
 * @Date 2020-02-20 17:52
 */

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
