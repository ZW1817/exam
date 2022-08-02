package com.kaifamiao.service;

import com.kaifamiao.model.ShijuanModel;
import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.provider.ShijuanProvider;
import com.kaifamiao.provider.ShijuanitemProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public interface ShijuanitemService {

    int insert(ShijuanitemModel record);

    int delete(ShijuanitemModel record);

    int update(ShijuanitemModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<ShijuanitemModel> selectAll(ShijuanitemModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<ShijuanitemModel> selectAllXuanze(ShijuanitemModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<ShijuanitemModel> selectAllPanduan(ShijuanitemModel record);

    List<ShijuanitemModel> selectAllTiankong(ShijuanitemModel record);

    List<ShijuanitemModel> selectAllJianda(ShijuanitemModel record);

}
