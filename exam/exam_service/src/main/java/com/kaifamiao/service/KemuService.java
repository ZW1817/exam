package com.kaifamiao.service;

import com.kaifamiao.mapper.KemuMapper;
import com.kaifamiao.model.KemuModel;
import com.kaifamiao.model.PanduanModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface KemuService {

    int insert(KemuModel record);

    int delete(KemuModel record);

    int update(KemuModel record);

    List<KemuModel> findAll(KemuModel record);

    KemuModel findOne(int  id);

}
