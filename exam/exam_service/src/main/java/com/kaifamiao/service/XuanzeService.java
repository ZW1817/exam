package com.kaifamiao.service;

import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.provider.XuanzeProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface XuanzeService {

    int insert(XuanzeModel record);

    int delete(XuanzeModel record);

    int update(XuanzeModel record);

    List<XuanzeModel> findAll(XuanzeModel record);

    XuanzeModel findOne(int  id);

    List<XuanzeModel> selectRandNum(Integer num);
}
