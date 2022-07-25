package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.JiandaMapper;
import com.kaifamiao.mapper.TiankongMapper;
import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.service.JiandaService;
import com.kaifamiao.service.TiankongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jiandaService")
public class JiandaServiceImpl implements JiandaService {

    @Autowired
    private JiandaMapper jiandaMapper;

    @Override
    public int insert(JiandaModel record) {
        return jiandaMapper.insert(record);
    }

    @Override
    public int delete(JiandaModel record) {
        return jiandaMapper.delete(record);
    }

    @Override
    public int update(JiandaModel record) {
        return jiandaMapper.update(record);
    }

    @Override
    public List<JiandaModel> findAll(JiandaModel record) {
        return jiandaMapper.selectAll(record);
    }

    @Override
    public JiandaModel findOne(int id){
        return jiandaMapper.selectOne(id);
    }

    @Override
    public List<JiandaModel> selectRandNum(Integer num) {
        return jiandaMapper.selectRandNum(num);
    }
}
