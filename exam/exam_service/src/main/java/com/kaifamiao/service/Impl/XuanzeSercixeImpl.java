package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.XuanzeMapper;
import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.service.XuanzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("xuanzeService")
public class XuanzeSercixeImpl implements XuanzeService {

    @Autowired
    private XuanzeMapper xuanzeMapper;

    @Override
    public int insert(XuanzeModel record) {
        return xuanzeMapper.insert(record);
    }

    @Override
    public int delete(XuanzeModel record) {
        return xuanzeMapper.delete(record);
    }

    @Override
    public int update(XuanzeModel record) {
        return xuanzeMapper.update(record);
    }

    @Override
    public List<XuanzeModel> findAll(XuanzeModel record) {
        return xuanzeMapper.selectAll(record);
    }

    @Override
    public XuanzeModel findOne(int id){
        return xuanzeMapper.selectOne(id);
    }

    @Override
    public List<XuanzeModel> selectRandNum(Integer num) {
        return xuanzeMapper.selectRandNum(num);
    }
}
