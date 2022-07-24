package com.kaifamiao.provider;

import com.kaifamiao.model.ShijuanitemModel;
import org.apache.ibatis.jdbc.SQL;

public class ShijuanitemProvider {

    private static final String tableName = "dajuanitem";

    public String delete(ShijuanitemModel record){
        return new SQL(){{
            DELETE_FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getShijuanid() != null) WHERE("shijuanid = #{shijuanid}");
                if(record.getFenshu() != null) WHERE("fenshu = #{fenshu}");
                if(record.getTihao() != null) WHERE("tihao = #{tihao}");
                if(record.getQtype() != null) WHERE("qtype = #{qtype}");
            }
        }}.toString();
    }

    public String insert(ShijuanitemModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null){
                if(record.getShijuanid() != null) VALUES("shijuanid","#{shijuanid}");
                if(record.getFenshu() != null) VALUES("fenshu","#{fenshu}");
                if(record.getId() != null) VALUES("id","#{id}");
                if(record.getQtype() != null) VALUES("qtype","#{qtype}");
                if(record.getTihao() != null) VALUES("tihao","#{tihao}");
                if(record.getQtype() != null) VALUES("qtype","#{qtype}");
            }
        }}.toString();
    }

    public String update(ShijuanitemModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null){
                if(record.getShijuanid() != null) WHERE("shijuanid = #{shijuanid}");
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getFenshu() != null) SET("fenshu = #{fenshu}");
                if(record.getQtype() != null) SET("qtype = #{qtype}");
                if(record.getTihao() != null) SET("tihao = #{tihao}");
                if(record.getQtype() != null) SET("qtype = #{qtype}");
            }
        }}.toString();
    }

    public String selectAll(ShijuanitemModel record){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getShijuanid() != null) WHERE("shijuanid = #{shijuanid}");
                if(record.getFenshu() != null) WHERE("fenshu = #{fenshu}");
                if(record.getQtype() != null) WHERE("qtype = #{qtype}");
                if(record.getTihao() != null) WHERE("tihao = #{tihao}");
                if(record.getQtype() != null) WHERE("qtype = #{qtype}");
            }
        }}.toString();
    }
}
