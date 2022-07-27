package com.kaifamiao.service;

import com.kaifamiao.model.ShijuanModel;
import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.provider.ShijuanProvider;
import com.kaifamiao.provider.ShijuanitemProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShijuanitemService {

    int insert(ShijuanitemModel record);

    int delete(ShijuanitemModel record);

    int update(ShijuanitemModel record);

    List<ShijuanitemModel> selectAll(ShijuanitemModel record);

    List<ShijuanitemModel> selectAllXuanze(ShijuanitemModel record);

    List<ShijuanitemModel> selectAllPanduan(ShijuanitemModel record);

    List<ShijuanitemModel> selectAllTiankong(ShijuanitemModel record);

    List<ShijuanitemModel> selectAllJianda(ShijuanitemModel record);

}
