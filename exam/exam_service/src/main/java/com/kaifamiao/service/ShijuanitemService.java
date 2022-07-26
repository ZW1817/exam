package com.kaifamiao.service;

import com.kaifamiao.model.ShijuanModel;
import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.provider.ShijuanProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShijuanitemService {

    int insert(ShijuanitemModel record);

    int delete(ShijuanitemModel record);

    int update(ShijuanitemModel record);

    List<ShijuanitemModel> selectAll(ShijuanitemModel record);

}
