package com.kaifamiao.mapper;

import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.model.PanduanModel;
import com.kaifamiao.provider.PanduanProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
* @author HP1
* @description 针对表【panduan】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Panduan
*/
public interface PanduanMapper {

    @InsertProvider(type = PanduanProvider.class,method = "insert")
    int insert(PanduanModel record);

    @DeleteProvider(type = PanduanProvider.class, method = "delete")
    int delete(PanduanModel record);

    @UpdateProvider(type = PanduanProvider.class,method = "update")
    int update(PanduanModel record);

    @SelectProvider(type = PanduanProvider.class, method = "selectAll")
    List<PanduanModel> selectAll(PanduanModel record);

}
