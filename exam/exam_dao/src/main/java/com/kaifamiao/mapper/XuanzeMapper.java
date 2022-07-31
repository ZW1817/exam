package com.kaifamiao.mapper;

import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.model.XuanzeModel;
import com.kaifamiao.provider.XuanzeProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author HP1
* @description 针对表【xuanze】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Xuanze
*/
public interface XuanzeMapper {

    @InsertProvider(type = XuanzeProvider.class,method = "insert")
    int insert(XuanzeModel record);

    @DeleteProvider(type = XuanzeProvider.class, method = "delete")
    int delete(XuanzeModel record);

    @UpdateProvider(type = XuanzeProvider.class,method = "update")
    int update(XuanzeModel record);

    @SelectProvider(type = XuanzeProvider.class, method = "selectAll")
    List<XuanzeModel> selectAll(XuanzeModel record);

    @Select("select * from xuanze where id = #{id}}")
    XuanzeModel selectOne(int id);

    @SelectProvider(type = XuanzeProvider.class, method = "selectRandNum")
    List<XuanzeModel> selectRandNum(Integer num);

}
