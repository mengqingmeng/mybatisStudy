package top.mengtech.service;

import top.mengtech.web.model.SysDict;

import java.util.List;

public interface DictService {
    SysDict findById(Long id);
    List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit);
    boolean saveOrUpdate(SysDict sysDict);
    boolean deleteById(Long id);
}
