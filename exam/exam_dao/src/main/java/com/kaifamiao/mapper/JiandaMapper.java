package com.kaifamiao.mapper;

import com.kaifamiao.model.JiandaModel;
import com.kaifamiao.provider.JiandaProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
* @author HP1
* @description 针对表【jianda】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Jianda
*/
public interface JiandaMapper {

    @InsertProvider(type = JiandaProvider.class,method = "insert")
    int insert(JiandaModel record);

    @DeleteProvider(type = JiandaProvider.class, method = "delete")
    int delete(JiandaModel record);

    @UpdateProvider(type = JiandaProvider.class,method = "update")
    int update(JiandaModel record);

    @SelectProvider(type = JiandaProvider.class, method = "selectAll")
    List<JiandaModel> selectAll(JiandaModel record);
}
