package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.DajuanitemMapper;
import com.kaifamiao.model.DajuanitemModel;
import com.kaifamiao.service.DajuanitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dajuanitemService")
public class DajuanitemServiceImpl implements DajuanitemService {

    @Autowired
    private DajuanitemMapper dajuanitemMapper;

    @Override
    public int delete(DajuanitemModel record) {
        return dajuanitemMapper.delete(record);
    }

    @Override
    public int insert(DajuanitemModel record) {
        return dajuanitemMapper.insert(record);
    }

    @Override
    public int update(DajuanitemModel record) {
        return dajuanitemMapper.update(record);
    }

    @Override
    public DajuanitemModel selectAll(DajuanitemModel record) {
        return dajuanitemMapper.selectAll(record);
    }

    @Override
    public List<DajuanitemModel> selectAllXuanze(DajuanitemModel record) {
        return dajuanitemMapper.selectAllXuanze(record);
    }

    @Override
    public List<DajuanitemModel> selectAllPanduan(DajuanitemModel record) {
        return dajuanitemMapper.selectAllPanduan(record);
    }

    @Override
    public List<DajuanitemModel> selectAllTiankong(DajuanitemModel record) {
        return dajuanitemMapper.selectAllTiankong(record);
    }

    @Override
    public List<DajuanitemModel> selectAllJianda(DajuanitemModel record) {
        return dajuanitemMapper.selectAllJianda(record);
    }
}
