package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.PaperstateMapper;
import com.kaifamiao.service.PaperstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("paperstateService")
public class PaperstateServiceImpl implements PaperstateService {

    @Autowired
    private PaperstateMapper paperstateMapper;

    @Override
    public List<Map<String, Object>> selectStdudent() {
        return paperstateMapper.selectStdudent();
    }
}
