package com.kaifamiao.service;

import com.kaifamiao.model.BanjiModel;

public interface BanjiService {

    int  insert(BanjiModel record);

    int delete(int id);

    int update(BanjiModel record);

    BanjiModel selectByid(int id);

//    List<Banji> selectAll(Banji record);

}
