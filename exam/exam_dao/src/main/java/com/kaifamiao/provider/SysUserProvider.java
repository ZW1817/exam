package com.kaifamiao.provider;

import com.kaifamiao.model.SysuserModel;
import org.apache.ibatis.jdbc.SQL;

public class SysUserProvider {
    private static final String tableName = "sysuser";

    public String update(SysuserModel record) {
        return new SQL() {{
            UPDATE(tableName);
            if (record != null) {
                if (record.getId() != null) WHERE("id = #{id}");
                if (record.getPassword() != null) SET("password = #{password}");
                if (record.getSex() != null) SET("sex = #{sex}");
                if (record.getRealname() != null) SET("realname = #{realname}");
                if (record.getUsername() != null) SET("username = #{username}");
                if (record.getPhoto() != null) SET("photo = #{photo}");
                if(record.getEmail() != null) SET("email = #{email}");
                if(record.getTell() != null) SET("tell = #{tell}");
            }
        }}.toString();
    }

    public String selectAll(SysuserModel record){
        return new SQL() {{
            SELECT("*");
            FROM(tableName);
            if(record != null) {
                if (record.getUsername() != null) WHERE("username = #{username}");
                if (record.getPassword() != null) WHERE("password = #{password}");
            }
        }}.toString();
    }
}
