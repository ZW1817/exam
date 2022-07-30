package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.BanjiMapper;
import com.kaifamiao.model.BanjiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return banjiMapper.delete(id);
    }

    @Override
    public int update(BanjiModel record) {
        return banjiMapper.update(record);
    }

    @Override
    public BanjiModel selectByid(int id) {
        return banjiMapper.selectOne(id);
    }

    @Override
    public List<BanjiModel> selectAll(BanjiModel record) {
        return banjiMapper.selectAll(record);
    }


}
