package com.kaifamiao.mapper;

import com.kaifamiao.model.KemuModel;
import com.kaifamiao.provider.KemuProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
* @author HP1
* @description 针对表【kemu】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Kemu
*/
public interface KemuMapper {

    @InsertProvider(type = KemuProvider.class, method = "insert")
    int insert(KemuModel record);

    @InsertProvider(type = KemuProvider.class,method = "delete")
    int delete(KemuModel record);

    @UpdateProvider(type = KemuProvider.class,method = "update")
    int update(KemuModel record);

    @SelectProvider(type = KemuProvider.class,method = "selectAll")
    List<KemuModel> selectAll(KemuModel record);


}
