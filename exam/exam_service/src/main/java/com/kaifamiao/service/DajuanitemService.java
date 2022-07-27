package com.kaifamiao.service;

import com.kaifamiao.model.DajuanitemModel;
import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.provider.DajuanitemProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface DajuanitemService {

    int delete(DajuanitemModel record);

    int insert(DajuanitemModel record);

    int update(DajuanitemModel record);

    DajuanitemModel selectAll(DajuanitemModel record);

    List<DajuanitemModel> selectAllXuanze(DajuanitemModel record);

    List<DajuanitemModel> selectAllPanduan(DajuanitemModel record);

    List<DajuanitemModel> selectAllTiankong(DajuanitemModel record);

    List<DajuanitemModel> selectAllJianda(DajuanitemModel record);
}
