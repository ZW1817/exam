package com.kaifamiao.service;

import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.XuanzeModel;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public interface JiandaService {

    int insert(JiandaModel record);

    int delete(JiandaModel record);

    int update(JiandaModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<JiandaModel> findAll(JiandaModel record);

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    JiandaModel findOne(int  id );

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<JiandaModel> selectRandNum(Integer num);
}
