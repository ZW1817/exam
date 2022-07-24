package com.kaifamiao.provider;

import com.kaifamiao.model.StudentModel;
import com.kaifamiao.model.TeacherModel;
import org.apache.ibatis.jdbc.SQL;

public class StudentProvider {

    private static final String tableName = "student";

    public String insert(StudentModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null) {
                if(record.getId() != null) VALUES("id" ,"#{id}");
                if(record.getJiguan() != null) VALUES("jiguan","#{jiguan}");
                if(record.getName() != null) VALUES("name","#{name}");
                if(record.getNation() != null) VALUES("nation","#{nation}");
                if(record.getPassword() != null) VALUES("password","#{password}");
                if(record.getPhoto() != null) VALUES("photo","#{photo}");
                if(record.getSex() != null) VALUES("sex","#{sex}");
                if(record.getAddress() != null) VALUES("address","#{address}");
                if(record.getBirthday() != null) VALUES("birthday","#{birthday}");
                if(record.getClassid() != null) VALUES("classid","#{classid}");
                if(record.getDes() != null) VALUES("des","#{des}");
                if(record.getZhuanye() != null) VALUES("zhuanye","zhuanye");
                if(record.getStno() != null) VALUES("stno","#{stno}");
                if(record.getMianmao() != null) VALUES("mianmao","#{mianmao}");
                if(record.getTell() != null) VALUES("tell","#{tell}");
            }
        }}.toString();
    }

    public String update(StudentModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null) {
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getStno() != null) WHERE("stno = #{stno}");
                if(record.getJiguan() != null) SET("jiguan = #{jiguan}");
                if(record.getName() != null) SET("name = #{name}");
                if(record.getNation() != null) SET("nation = #{nation}");
                if(record.getPassword() != null) SET("password = #{password}");
                if(record.getPhoto() != null) SET("photo = #{photo}");
                if(record.getSex() != null) SET("sex = #{sex}");
                if(record.getAddress() != null) SET("address = #{address}");
                if(record.getBirthday() != null) SET("birthday = #{birthday}");
                if(record.getClassid() != null) SET("classid = #{classid}");
                if(record.getDes() != null) SET("des = #{des}");
                if(record.getZhuanye() != null) SET("zhuanye = zhuanye");
                if(record.getMianmao() != null) SET("mianmao = #{mianmao}");
                if(record.getTell() != null) SET("tell = #{tell}");

            }
        }}.toString();
    }


    public String selectAll(StudentModel record){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            if(record != null) {
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getStno() != null) WHERE("stno = #{stno}");
                if(record.getJiguan() != null) WHERE("jiguan = #{jiguan}");
                if(record.getName() != null) WHERE("name = #{name}");
                if(record.getNation() != null) WHERE("nation = #{nation}");
                if(record.getPassword() != null) WHERE("password = #{password}");
                if(record.getPhoto() != null) WHERE("photo = #{photo}");
                if(record.getSex() != null) WHERE("sex = #{sex}");
                if(record.getAddress() != null) WHERE("address = #{address}");
                if(record.getBirthday() != null) WHERE("birthday = #{birthday}");
                if(record.getClassid() != null) WHERE("classid = #{classid}");
                if(record.getDes() != null) WHERE("des = #{des}");
                if(record.getZhuanye() != null) WHERE("zhuanye = zhuanye");
                if(record.getMianmao() != null) WHERE("mianmao = #{mianmao}");
                if(record.getTell() != null) WHERE("tell = #{tell}");

            }
        }}.toString();
    }
}
