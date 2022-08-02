package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.INoAnswerMapper;
import com.kaifamiao.model.NoAnswerModel;
import com.kaifamiao.service.INoAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoAnswerServiceImpl implements INoAnswerService {

    @Autowired
    private INoAnswerMapper noAnswerMapper;

    @Override
    public List<NoAnswerModel> findAll(String stno) {
        return noAnswerMapper.selectAll(stno);
    }
}
