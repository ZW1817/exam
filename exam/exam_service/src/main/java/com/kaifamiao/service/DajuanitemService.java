package com.kaifamiao.service;

import com.kaifamiao.model.DajuanitemModel;
import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.provider.DajuanitemProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public interface DajuanitemService {

    int delete(DajuanitemModel record);

    int insert(DajuanitemModel record);

    int update(DajuanitemModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    DajuanitemModel selectAll(DajuanitemModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<DajuanitemModel> selectAllXuanze(DajuanitemModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<DajuanitemModel> selectAllPanduan(DajuanitemModel record);

    List<DajuanitemModel> selectAllTiankong(DajuanitemModel record);

    List<DajuanitemModel> selectAllJianda(DajuanitemModel record);
}
