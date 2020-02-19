package top.mengtech.springboot_mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Country {
    private Long id;
    private String countryName;
    private String countryCode;
}
