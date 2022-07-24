package com.kaifamiao.service;

import com.kaifamiao.model.BanjiModel;

import java.util.List;

public interface BanjiService {

    int  insert(BanjiModel record);

    int delete(int id);

    int update(BanjiModel record);

    BanjiModel selectByid(int id);

    List<BanjiModel> selectAll(BanjiModel record);

}
