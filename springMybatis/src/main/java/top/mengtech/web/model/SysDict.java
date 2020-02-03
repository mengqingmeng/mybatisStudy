package top.mengtech.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class SysDict implements Serializable {
    private static final long serialVersionUID = -4951559513582745662L;
    private Long id;
    private String code;
    private String name;
    private String value;
}
