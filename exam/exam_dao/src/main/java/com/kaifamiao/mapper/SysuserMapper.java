package com.kaifamiao.mapper;

import com.kaifamiao.model.SysuserModel;
import com.kaifamiao.provider.SysUserProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
* @author HP1
* @description 针对表【sysuser】的数据库操作Mapper
* @createDate 2022-07-23 16:03:34
* @Entity com.kaifamiao.model.Sysuser
*/
public interface SysuserMapper {

    @UpdateProvider(type = SysUserProvider.class,method = "update")
    int update(SysuserModel record);

    @SelectProvider(type = SysUserProvider.class,method = "selectAll")
    List<SysuserModel> selectAll(SysuserModel record);

}
