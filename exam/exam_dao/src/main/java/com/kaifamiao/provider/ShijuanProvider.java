package com.kaifamiao.provider;

import com.kaifamiao.model.ShijuanModel;
import org.apache.ibatis.jdbc.SQL;

public class ShijuanProvider {
    private static final String tableName = "shijuan";

    public String insert(ShijuanModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null){
                if(record.getId() != null) VALUES("id","#{id}");
                if(record.getDiffaclt() != null) VALUES("diffaclt", "#{diffaclt}");
                if(record.getKmid() != null) VALUES("kmid","#{kmid}");
                if(record.getStarttime() != null) VALUES("starttime","#{starttime}");
                if(record.getTitle() != null) VALUES("title","#{title}");
                if(record.getZongfen() != null) VALUES("zonngfeng","#{zongfeng}");
                if(record.getTno() != null) VALUES("tno","#{tno}");
            }
        }}.toString();
    }

    public String delete(ShijuanModel record){
        return new SQL(){{
            DELETE_FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getDiffaclt() != null) WHERE("diffaclt = #{diffaclt}");
                if(record.getKmid() != null) WHERE("kmid = #{kmid}");
                if(record.getStarttime() != null) WHERE("starttime = #{starttime}");
                if(record.getTitle() != null) WHERE("title = #{title}");
                if(record.getZongfen() != null) WHERE("zonngfeng = #{zongfeng}");
                if(record.getTno() != null) WHERE("tno = #{tno}");
            }
        }}.toString();
    }

    public String update(ShijuanModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getKmid() != null) WHERE("kmid = #{kmid}");
                if(record.getTno() != null) WHERE("tno = #{tno}");
                if(record.getDiffaclt() != null) SET("diffaclt = #{diffaclt}");
                if(record.getStarttime() != null) SET("starttime = #{starttime}");
                if(record.getTitle() != null) SET("title = #{title}");
                if(record.getZongfen() != null) SET("zonngfeng = #{zongfeng}");
            }
        }}.toString();
    }

    public String selectAll(ShijuanModel record){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getDiffaclt() != null) WHERE("diffaclt = #{diffaclt}");
                if(record.getKmid() != null) WHERE("kmid = #{kmid}");
                if(record.getStarttime() != null) WHERE("starttime = #{starttime}");
                if(record.getTitle() != null) WHERE("title = #{title}");
                if(record.getZongfen() != null) WHERE("zonngfeng = #{zongfeng}");
                if(record.getTno() != null) WHERE("tno = #{tno}");
            }
        }}.toString();
    }


}
