package com.kaifamiao.mapper;

import com.kaifamiao.model.BanjiModel;
import com.kaifamiao.provider.BanjiProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
* @author HP1
* @description 针对表【banji】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Banji
*/
public interface BanjiMapper {

    @InsertProvider(type = BanjiProvider.class,method = "insert")
    int insert(BanjiModel record);

    @DeleteProvider(type = BanjiProvider.class,method = "deleteByPrimaryKey")
    int deleteByPrimaryKey(int id);

    @SelectProvider(type = BanjiProvider.class,method = "selectByPrimaryKey")
    BanjiModel selectByPrimaryKey(int id);

    @UpdateProvider(type = BanjiProvider.class,method = "updateByPrimaryKey")
    int updateByPrimaryKey(BanjiModel record);


}
