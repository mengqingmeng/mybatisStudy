package top.mengtech.springboot_mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.mengtech.springboot_mybatis.model.Country;

import java.util.List;

@Mapper
@Repository
public interface CountryMapper {
    List<Country> selectAll();
}
