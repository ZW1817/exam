package com.kaifamiao.provider;

import com.kaifamiao.model.TeacherModel;
import org.apache.ibatis.jdbc.SQL;

public class TeacherProvider {

    private static final String tableName = "teacher";

    public String insert(TeacherModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null) {
                if(record.getId() != null) VALUES("id" ,"#{id}");
                if(record.getEmail() != null) VALUES("email","#{email}");
                if(record.getJieshao() != null) VALUES("jieshao","#{jieshao}");
                if(record.getJiguan() != null) VALUES("jiguan","#{jiguan}");
                if(record.getMajor() != null) VALUES("major","#{major}");
                if(record.getName() != null) VALUES("name","#{name}");
                if(record.getNation() != null) VALUES("nation","#{nation}");
                if(record.getPassword() != null) VALUES("password","#{password}");
                if(record.getPhoto() != null) VALUES("photo","#{photo}");
                if(record.getSex() != null) VALUES("sex","#{sex}");
                if(record.getTell() != null) VALUES("tell","#{tell}");
                if(record.getTno() != null) VALUES("tno","#{tno}");
                if(record.getXueli() != null) VALUES("xueli","#{xueli}");
                if(record.getZhicheng() != null) VALUES("zhicheng","#{zhicheng}");
            }
        }}.toString();
    }


    public String selectAll(TeacherModel record){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            if(record != null) {
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getTno() != null) WHERE("tno = #{tno}");
                if(record.getEmail() != null) WHERE("email = #{email}");
                if(record.getJieshao() != null) WHERE("jieshao = #{jieshao}");
                if(record.getJiguan() != null) WHERE("jiguan = #{jiguan}");
                if(record.getMajor() != null) WHERE("major = #{major}");
                if(record.getName() != null) WHERE("name = #{name}");
                if(record.getNation() != null) WHERE("nation = #{nation}");
                if(record.getPassword() != null) WHERE("password = #{password}");
                if(record.getPhoto() != null) WHERE("photo =#{photo}");
                if(record.getSex() != null) WHERE("sex = #{sex}");
                if(record.getTell() != null) WHERE("tell = #{tell}");
                if(record.getXueli() != null) WHERE("xueli = #{xueli}");
                if(record.getZhicheng() != null) WHERE("zhicheng = #{zhicheng}");
            }
        }}.toString();
    }

    public String update(TeacherModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null) {
                if(record.getEmail() != null) SET("email = #{email}");
                if(record.getJieshao() != null) SET("jieshao = #{jieshao}");
                if(record.getJiguan() != null) SET("jiguan = #{jiguan}");
                if(record.getMajor() != null) SET("major = #{major}");
                if(record.getName() != null) SET("name = #{name}");
                if(record.getNation() != null) SET("nation = #{nation}");
                if(record.getPassword() != null) SET("password = #{password}");
                if(record.getPhoto() != null) SET("photo =#{photo}");
                if(record.getSex() != null) SET("sex = #{sex}");
                if(record.getTell() != null) SET("tell = #{tell}");
                if(record.getXueli() != null) SET("xueli = #{xueli}");
                if(record.getZhicheng() != null) SET("zhicheng = #{zhicheng}");
                if(record.getTno() != null) WHERE("tno = #{tno}");
                if(record.getId() != null) WHERE("id = #{id}");
            }
        }}.toString();
    }
}
