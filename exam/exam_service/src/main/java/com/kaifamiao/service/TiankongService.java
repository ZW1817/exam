package com.kaifamiao.service;

import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.model.XuanzeModel;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public interface TiankongService {

    int insert(TiankongModel record);

    int delete(TiankongModel record);

    int update(TiankongModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<TiankongModel> findAll(TiankongModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    TiankongModel findOne(int  id);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<TiankongModel> selectRandNum(Integer num);
}
