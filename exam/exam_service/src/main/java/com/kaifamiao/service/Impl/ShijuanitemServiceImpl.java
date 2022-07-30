package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.ShijuanitemMapper;
import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.service.ShijuanitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shijuanitemService")
public class ShijuanitemServiceImpl implements ShijuanitemService {

    @Autowired
    private ShijuanitemMapper shijuanitemMapper;

    @Override
    public int insert(ShijuanitemModel record) {
        return shijuanitemMapper.insert(record);
    }

    @Override
    public int delete(ShijuanitemModel record) {
        return shijuanitemMapper.delete(record);
    }

    @Override
    public int update(ShijuanitemModel record) {
        return shijuanitemMapper.update(record);
    }

    @Override
    public List<ShijuanitemModel> selectAll(ShijuanitemModel record) {
        return shijuanitemMapper.selectAll(record);
    }

    @Override
    public List<ShijuanitemModel> selectAllXuanze(ShijuanitemModel record) {
        return shijuanitemMapper.selectAllXuanze(record);
    }

    @Override
    public List<ShijuanitemModel> selectAllPanduan(ShijuanitemModel record) {
        return shijuanitemMapper.selectAllPanduan(record);
    }

    @Override
    public List<ShijuanitemModel> selectAllTiankong(ShijuanitemModel record) {
        return shijuanitemMapper.selectAllTianKong(record);
    }

    @Override
    public List<ShijuanitemModel> selectAllJianda(ShijuanitemModel record) {
        return shijuanitemMapper.selectAllJianda(record);
    }

}
