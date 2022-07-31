package com.kaifamiao.mapper;

import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.provider.ShijuanitemProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
* @author HP1
* @description 针对表【shijuanitem】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Shijuanitem
*/
public interface ShijuanitemMapper {
    @DeleteProvider(type = ShijuanitemProvider.class,method = "delete")
    int delete(ShijuanitemModel record);

    @InsertProvider(type = ShijuanitemProvider.class,method = "insert")
    int insert(ShijuanitemModel record);

    @UpdateProvider(type = ShijuanitemProvider.class, method = "update")
    int update(ShijuanitemModel record);

    @SelectProvider(type = ShijuanitemProvider.class,method = "selectAll")
    List<ShijuanitemModel> selectAll(ShijuanitemModel record);

    @SelectProvider(type = ShijuanitemProvider.class, method = "selectAllXuanze")
    List<ShijuanitemModel> selectAllXuanze(ShijuanitemModel record);

    @SelectProvider(type = ShijuanitemProvider.class, method = "selectAllPanduan")
    List<ShijuanitemModel> selectAllPanduan(ShijuanitemModel record);

    @SelectProvider(value = ShijuanitemProvider.class,method = "selectAllTianKong")
    List<ShijuanitemModel> selectAllTianKong(ShijuanitemModel record);


    @SelectProvider(type = ShijuanitemProvider.class, method = "selectAllJianda")
    List<ShijuanitemModel> selectAllJianda(ShijuanitemModel record);


}
