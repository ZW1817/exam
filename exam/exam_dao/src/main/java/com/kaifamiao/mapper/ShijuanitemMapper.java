package com.kaifamiao.mapper;

import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.provider.ShijuanitemProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

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
    ShijuanitemModel selectAll(ShijuanitemModel record);

}
