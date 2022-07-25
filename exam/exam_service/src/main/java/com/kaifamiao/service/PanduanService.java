package com.kaifamiao.service;

import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.TiankongModel;

import java.util.List;

public interface PanduanService {

    int insert(PanduanModel record);

    int delete(PanduanModel record);

    int update(PanduanModel record);

    List<PanduanModel> findAll(PanduanModel record);

    PanduanModel findOne(int  id);

    List<PanduanModel> selectRandNum(Integer num);
}
