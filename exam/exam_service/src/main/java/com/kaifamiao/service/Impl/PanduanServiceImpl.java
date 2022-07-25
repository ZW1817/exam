package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.PanduanMapper;
import com.kaifamiao.mapper.XuanzeMapper;
import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.service.PanduanService;
import com.kaifamiao.service.XuanzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("panduanService")
public class PanduanServiceImpl implements PanduanService {

    @Autowired
    private PanduanMapper panduanMapper;

    @Override
    public int insert(PanduanModel record) {
        return panduanMapper.insert(record);
    }

    @Override
    public int delete(PanduanModel record) {
        return panduanMapper.delete(record);
    }

    @Override
    public int update(PanduanModel record) {
        return panduanMapper.update(record);
    }

    @Override
    public List<PanduanModel> findAll(PanduanModel record) {
        return panduanMapper.selectAll(record);
    }

    @Override
    public PanduanModel findOne(int id){
        return panduanMapper.selectOne(id);
    }
}
