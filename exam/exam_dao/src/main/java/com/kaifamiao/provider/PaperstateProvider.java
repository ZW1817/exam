package com.kaifamiao.provider;

import com.kaifamiao.model.PaperstateModel;
import org.apache.ibatis.jdbc.SQL;

import java.awt.print.Paper;

public class PaperstateProvider {
    private static final String tableName = "paperstate";

    public String insert(PaperstateModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null){
                if(record.getId() != null) VALUES("id","#{id}");
                if(record.getShijuanid() != null) VALUES("shijuanid","#{shijuanid}");
                if(record.getStno() != null) VALUES("stno","#{stno}");
                if(record.getYstate() != null) VALUES("ystate", "#{ystate}");
                if(record.getDstate() != null) VALUES("dstate", "#{dstate}");
            }
        }}.toString();
    }

    public String update(PaperstateModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getShijuanid() != null) SET("shijuanid = #{shijuanid}");
                if(record.getStno() != null) SET("stno = #{stno}");
                if(record.getYstate() != null) SET("ystate  = #{ystate}");
                if(record.getDstate() != null) SET("dstate = #{dstate}");
            }
        }}.toString();
    }

    public String selectAll(PaperstateModel record){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getShijuanid() != null) WHERE("shijuanid = #{shijuanid}");
                if(record.getStno() != null) WHERE("stno = #{stno}");
                if(record.getYstate() != null) WHERE("ystate  = #{ystate}");
                if(record.getDstate() != null) WHERE("dstate = #{dstate}");
            }
        }}.toString();
    }

    public String selectStudent(){
        return new SQL(){{
            SELECT("s.id, s.title AS title , b.name AS banji, p.stno AS stno , p.dstate AS Dstatus ,p.ystate AS Ystatus ,p.score AS Sscore");
            FROM("shijuan s, banji b , paperstate p");
            WHERE("s.tno=b.tno AND p.shijuanid=s.id");
        }}.toString();
    }

}
