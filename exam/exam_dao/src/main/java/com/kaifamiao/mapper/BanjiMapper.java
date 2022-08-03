package com.kaifamiao.mapper;

import com.kaifamiao.model.BanjiModel;
import com.kaifamiao.provider.BanjiProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author HP1
* @description 针对表【banji】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Banji
*/
public interface BanjiMapper {

    @InsertProvider(type = BanjiProvider.class,method = "insert")
    int insert(BanjiModel record);

    @DeleteProvider(type = BanjiProvider.class,method = "delete")
    int delete(int id);

    @UpdateProvider(type = BanjiProvider.class,method = "update")
    int update(BanjiModel record);

    @SelectProvider(type = BanjiProvider.class,method = "selectOne")
    BanjiModel selectOne(int id);

    @SelectProvider(type = BanjiProvider.class,method = "selectByName")
    BanjiModel selectByName(String name);

    @SelectProvider(type = BanjiProvider.class, method = "selectAll")
    List<BanjiModel> selectAll(BanjiModel record);

}
