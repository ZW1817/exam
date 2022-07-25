package com.kaifamiao.mapper;

import com.kaifamiao.model.PaperstateModel;
import com.kaifamiao.provider.PaperstateProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
* @author HP1
* @description 针对表【paperstate】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Paperstate
*/
public interface PaperstateMapper {

    @InsertProvider(type = PaperstateProvider.class, method = "insert")
    int insert(PaperstateModel record);

    @Delete("delete from paperstate where id= #{id}}")
    int delete(int id);

    @UpdateProvider(type = PaperstateProvider.class, method = "update")
    int update(PaperstateModel record);

    @Select("select * from paperstate where id = #{id}}")
    PaperstateModel selectOne(int id);

    @SelectProvider(type = PaperstateProvider.class, method = "selectAll")
   List<PaperstateModel> selectAll(PaperstateModel record);

    @SelectProvider(type = PaperstateProvider.class, method = "selectStdudent")
    List<Map<String, Object>> selectStdudent();
}
