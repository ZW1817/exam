package com.kaifamiao.service;

import com.kaifamiao.mapper.KemuMapper;
import com.kaifamiao.model.KemuModel;
import com.kaifamiao.model.PanduanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public interface KemuService {

    int insert(KemuModel record);

    int delete(KemuModel record);

    int update(KemuModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<KemuModel> findAll(KemuModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    KemuModel findOne(int  id);

}
