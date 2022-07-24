package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.BanjiMapper;
import com.kaifamiao.model.BanjiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("banjiService")
public class BanjiServiceImpl implements com.kaifamiao.service.BanjiService {

    @Autowired
    private BanjiMapper banjiMapper;

    @Override
    public int insert(BanjiModel record) {
        return banjiMapper.insert(record);
    }

    @Override
    public int delete(int id) {
        return banjiMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(BanjiModel record) {
        return banjiMapper.updateByPrimaryKey(record);
    }

    @Override
    public BanjiModel selectByid(int id) {
        return banjiMapper.selectByPrimaryKey(id);
    }
//
//    @Override
//    public List<Banji> selectAll(Banji record) {
//        return banjiMapper.
//    }


}
