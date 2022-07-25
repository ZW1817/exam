package com.kaifamiao.service;

import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.model.XuanzeModel;

import java.util.List;

public interface TiankongService {

    int insert(TiankongModel record);

    int delete(TiankongModel record);

    int update(TiankongModel record);

    List<TiankongModel> findAll(TiankongModel record);

    TiankongModel findOne(int  id);
}
