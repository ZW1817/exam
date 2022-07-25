package com.kaifamiao.mapper;

import com.kaifamiao.model.AnswerModel;
import com.kaifamiao.provider.AnswerProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface IAnswerMapper {

    @SelectProvider(value = AnswerProvider.class,method = "selectAllAnswer")
    List<AnswerModel> selectAllAnswer();
}
