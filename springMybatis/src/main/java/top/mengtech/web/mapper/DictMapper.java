package top.mengtech.web.mapper;

import org.apache.ibatis.session.RowBounds;
import top.mengtech.web.model.SysDict;

import java.util.List;

public interface DictMapper {
    SysDict selectByPrimaryKey(Long id);
    List<SysDict> selectBySysDict(SysDict sysDict, RowBounds rowBounds);
    int insert(SysDict sysDict);
    int updateById(SysDict sysDict);
    int deleteById(Long id);
}
