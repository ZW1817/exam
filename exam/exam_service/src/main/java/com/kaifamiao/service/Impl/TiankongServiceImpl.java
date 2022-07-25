package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.TiankongMapper;
import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.service.TiankongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tiankongService")
public class TiankongServiceImpl implements TiankongService {

    @Autowired
    private TiankongMapper tiankongMapper;

    @Override
    public int insert(TiankongModel record) {
        return tiankongMapper.insert(record);
    }

    @Override
    public int delete(TiankongModel record) {
        return tiankongMapper.delete(record);
    }

    @Override
    public int update(TiankongModel record) {
        return tiankongMapper.update(record);
    }

    @Override
    public List<TiankongModel> findAll(TiankongModel record) {
        return tiankongMapper.selectAll(record);
    }

    @Override
    public TiankongModel findOne(int id){
        return tiankongMapper.selectOne(id);
    }
}
