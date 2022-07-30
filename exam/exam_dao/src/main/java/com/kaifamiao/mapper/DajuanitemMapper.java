package com.kaifamiao.mapper;

import com.kaifamiao.model.DajuanitemModel;
import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.provider.DajuanitemProvider;
import com.kaifamiao.provider.ShijuanitemProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
* @author HP1
* @description 针对表【dajuanitem】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Dajuanitem
*/
public interface DajuanitemMapper {

    @DeleteProvider(type = DajuanitemProvider.class,method = "delete")
    int delete(DajuanitemModel record);

    @InsertProvider(type = DajuanitemProvider.class,method = "insert")
    int insert(DajuanitemModel record);

    @UpdateProvider(type = DajuanitemProvider.class, method = "update")
    int update(DajuanitemModel record);

    @SelectProvider(type = DajuanitemProvider.class,method = "selectAll")
    DajuanitemModel selectAll(DajuanitemModel record);

    @SelectProvider(type = DajuanitemProvider.class, method = "selectAllXuanze")
    List<DajuanitemModel> selectAllXuanze(DajuanitemModel record);

    @SelectProvider(type = DajuanitemProvider.class, method = "selectAllPanduan")
    List<DajuanitemModel> selectAllPanduan(DajuanitemModel record);

    @SelectProvider(type = DajuanitemProvider.class, method = "selectAllTiankong")
    List<DajuanitemModel> selectAllTiankong(DajuanitemModel record);

    @SelectProvider(type = DajuanitemProvider.class, method = "selectAllJianda")
    List<DajuanitemModel> selectAllJianda(DajuanitemModel record);

}
