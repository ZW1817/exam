package com.kaifamiao.service;

import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.XuanzeModel;

import java.util.List;

public interface JiandaService {

    int insert(JiandaModel record);

    int delete(JiandaModel record);

    int update(JiandaModel record);

    List<JiandaModel> findAll(JiandaModel record);

    JiandaModel findOne(int  id );

    List<JiandaModel> selectRandNum(Integer num);
}
