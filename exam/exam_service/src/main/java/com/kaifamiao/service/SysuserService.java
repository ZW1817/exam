package com.kaifamiao.service;

import com.kaifamiao.model.SysuserModel;

import java.util.List;

public interface SysuserService {

    int update(SysuserModel record);

    List<SysuserModel> findAll(SysuserModel record);
}
