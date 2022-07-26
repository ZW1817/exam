package com.kaifamiao.service.Impl;

import com.kaifamiao.mapper.IAnswerMapper;
import com.kaifamiao.model.AnswerModel;
import com.kaifamiao.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private IAnswerMapper mapper;

    @Override
    public List<AnswerModel> findAllAnswer() {
        return mapper.selectAllAnswer();
    }
}
