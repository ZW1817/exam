package com.kaifamiao.mapper;

import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.model.TiankongModel;
import com.kaifamiao.provider.TiankongProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
* @author HP1
* @description 针对表【tiankong】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Tiankong
*/
public interface TiankongMapper {

    @InsertProvider(type = TiankongProvider.class,method = "insert")
    int insert(TiankongModel record);

    @DeleteProvider(type = TiankongProvider.class, method = "delete")
    int delete(TiankongModel record);

    @UpdateProvider(type = TiankongProvider.class,method = "update")
    int update(TiankongModel record);

    @SelectProvider(type = TiankongProvider.class, method = "selectAll")
    List<TiankongModel> selectAll(TiankongModel record);

}
