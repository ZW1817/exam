package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.PaperstateMapper;
import com.kaifamiao.mapper.ShijuanMapper;
import com.kaifamiao.model.PaperstateModel;
import com.kaifamiao.model.ShijuanModel;
import com.kaifamiao.service.PaperstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("paperstateService")
public class PaperstateServiceImpl implements PaperstateService {

    @Autowired
    private PaperstateMapper paperstateMapper;

    @Autowired
    private ShijuanMapper shijuanMapper;

    @Override
    public List<Map<String, Object>> selectStudent() {
        return paperstateMapper.selectStudent();
    }

    @Override
    public Integer createShijuan(ShijuanModel shijuanModel) {
        shijuanMapper.insertCallId(shijuanModel);
        int id=shijuanModel.getId();
        return id;
    }

    @Override
    public int insert(PaperstateModel paperstate) {
        return paperstateMapper.insert(paperstate);
    }

    @Override
    public int update(PaperstateModel paperstate) {
        return paperstateMapper.update(paperstate);
    }
}
