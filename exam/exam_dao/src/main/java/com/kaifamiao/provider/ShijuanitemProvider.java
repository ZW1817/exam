package com.kaifamiao.provider;

import com.kaifamiao.model.ShijuanitemModel;
import org.apache.ibatis.jdbc.SQL;

public class ShijuanitemProvider {

    private static final String tableName = "shijuanitem";

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

    public String selectAllXuanze(ShijuanitemModel record){
        return new SQL(){{
            SELECT("shijuanitem.*,xuanze.* ");
            FROM(tableName);
            if(record != null){
                if(record.getShijuanid() != null) WHERE("shijuanitem.shijuanid = #{shijuanid}");
                    WHERE("shijuanitem.qtype = #{qtype}");
                    JOIN( "xuanze on shijuanitem.tihao = xuanze.id ");
            }
        }}.toString();
    }

    public String selectAllPanduan(ShijuanitemModel record){
        return new SQL(){{
            SELECT("shijuanitem.*,panduan.* ");
            FROM(tableName);
            if(record != null){
                if(record.getShijuanid() != null) WHERE("shijuanitem.shijuanid = #{shijuanid}");
                WHERE("shijuanitem.qtype = #{qtype}");
                JOIN( "panduan on shijuanitem.tihao = panduan.id ");
            }
        }}.toString();
    }

    public String selectAllTianKong(ShijuanitemModel record){
        return new SQL(){{
            SELECT("shijuanitem.*,tiankong.title");
            FROM("shijuanitem");
            if (record != null){
                if (record.getShijuanid() != null) WHERE("shijuanitem.shijuanid = #{shijuanid}");
                WHERE("shijuanitem.qtype = #{qtype}");
                LEFT_OUTER_JOIN("tiankong on shijuanitem.tihao = tiankong.id");
            }
        }}.toString();
    }

    public String selectAllJianda(ShijuanitemModel record){
        return new SQL(){{
            SELECT("shijuanitem.*,jianda.* ");
            FROM(tableName);
            if(record != null){
                if(record.getShijuanid() != null) WHERE("shijuanitem.shijuanid = #{shijuanid}");
                WHERE("shijuanitem.qtype = #{qtype}");
                JOIN( "jianda on shijuanitem.tihao = jianda.id ");
            }
        }}.toString();
    }
}
