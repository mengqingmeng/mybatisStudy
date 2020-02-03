package top.mengtech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mengtech.service.DictService;
import top.mengtech.web.mapper.DictMapper;
import top.mengtech.web.model.SysDict;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;

    @Override
    public SysDict findById(Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public boolean saveOrUpdate(SysDict sysDict) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
