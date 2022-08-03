package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.KemuMapper;
import com.kaifamiao.model.KemuModel;
import com.kaifamiao.service.KemuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KemuServiceImpl implements KemuService {

    @Autowired
    private KemuMapper kemuMapper;

    @Override
    public int insert(KemuModel record) {
        return 0;
    }

    @Override
    public int delete(KemuModel record) {
        return 0;
    }

    @Override
    public int update(KemuModel record) {
        return 0;
    }

    @Override
    public List<KemuModel> findAll(KemuModel record) {
        return kemuMapper.selectAll(null);
    }

    @Override
    public KemuModel findOne(int id) {
        return null;
    }
}
