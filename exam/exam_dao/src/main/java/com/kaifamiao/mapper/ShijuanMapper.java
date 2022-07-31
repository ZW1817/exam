package com.kaifamiao.mapper;

import com.kaifamiao.model.ShijuanModel;
import com.kaifamiao.provider.ShijuanProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author HP1
* @description 针对表【shijuan】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Shijuan
*/
public interface ShijuanMapper {

    @InsertProvider(type = ShijuanProvider.class,method = "insert")
    int insert(ShijuanModel record);

    @DeleteProvider(type = ShijuanProvider.class, method = "delete")
    int delete(ShijuanModel record);

    @UpdateProvider(type = ShijuanProvider.class,method = "update")
    int update(ShijuanModel record);

    @SelectProvider(type = ShijuanProvider.class, method = "selectAll")
    List<ShijuanModel> selectAll(ShijuanModel record);


    @Insert("insert into Shijuan(kmid,title,zongfen,tno,starttime) values(#{kmid},#{title},#{zongfen},#{tno},#{starttime})")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    int insertCallId(ShijuanModel record);

}
