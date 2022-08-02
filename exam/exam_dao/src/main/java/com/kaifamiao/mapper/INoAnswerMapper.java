package com.kaifamiao.mapper;

import com.kaifamiao.model.NoAnswerModel;
import com.kaifamiao.provider.NoAnswerProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface INoAnswerMapper {

    @SelectProvider(value = NoAnswerProvider.class,method = "selectAll")
    List<NoAnswerModel> selectAll(String stno);
}