package com.kaifamiao.service;

import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.provider.XuanzeProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public interface XuanzeService {

    int insert(XuanzeModel record);

    int delete(XuanzeModel record);

    int update(XuanzeModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<XuanzeModel> findAll(XuanzeModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    XuanzeModel findOne(int  id);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<XuanzeModel> selectRandNum(Integer num);
}
