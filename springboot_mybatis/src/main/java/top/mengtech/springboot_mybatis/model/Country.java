package top.mengtech.springboot_mybatis.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private Long id;
    private String countryName;
    private String countryCode;
}
