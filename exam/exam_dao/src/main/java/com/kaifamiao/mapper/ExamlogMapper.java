package com.kaifamiao.mapper;

import com.kaifamiao.model.ExamlogModel;
import com.kaifamiao.provider.ExamlogProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
* @author HP1
* @description 针对表【examlog】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Examlog
*/
public interface ExamlogMapper {

    @InsertProvider(type = ExamlogProvider.class,method = "insert")
    int insert(ExamlogModel record);

    @DeleteProvider(type = ExamlogProvider.class,method = "delete")
    int delete(ExamlogModel record);

    @UpdateProvider(type = ExamlogProvider.class,method = "update")
    int update(ExamlogModel record);

    @SelectProvider(type = ExamlogProvider.class,method = "selectAll")
    List<ExamlogModel> selectAll(ExamlogModel record);

}
