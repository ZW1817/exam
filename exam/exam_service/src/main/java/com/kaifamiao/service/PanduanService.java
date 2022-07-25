package com.kaifamiao.service;

import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.PanduanModel;

import java.util.List;

public interface PanduanService {

    int insert(PanduanModel record);

    int delete(PanduanModel record);

    int update(PanduanModel record);

    List<PanduanModel> findAll(PanduanModel record);

    PanduanModel findOne(int  id);
}
