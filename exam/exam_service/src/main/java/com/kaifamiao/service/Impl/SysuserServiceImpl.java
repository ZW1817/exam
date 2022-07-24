package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.SysuserMapper;
import com.kaifamiao.model.SysuserModel;
import com.kaifamiao.service.SysuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysuserService")
public class SysuserServiceImpl implements SysuserService {

    @Autowired
    private SysuserMapper sysuserMapper;

    @Override
    public int update(SysuserModel record) {
        return sysuserMapper.update(record);
    }

    @Override
    public List<SysuserModel> findAll(SysuserModel record) {
        return sysuserMapper.selectAll(record);
    }
}
