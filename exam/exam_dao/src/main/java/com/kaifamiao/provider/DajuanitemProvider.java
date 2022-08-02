package com.kaifamiao.provider;

import com.kaifamiao.model.DajuanitemModel;
import com.kaifamiao.model.ShijuanitemModel;
import org.apache.ibatis.jdbc.SQL;

public class DajuanitemProvider {
    private static final String tableName = "dajuanitem";

    public String delete(DajuanitemModel record){
        return new SQL(){{
            DELETE_FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getStno() != null) WHERE("stno = #{stno}");
                if(record.getShijuanid() != null) WHERE("shijuanid = #{shijuanid}");
                if(record.getDaan() != null) WHERE("daan = #{daan}");
                if(record.getDefen() != null) WHERE("defen = #{defen}");
                if(record.getFenshu() != null) WHERE("fenshu = #{fenshu}");
                if(record.getQtype() != null) WHERE("qtype = #{qtype}");
                if(record.getTihao() != null) WHERE("tihao = #{tihao}");
                if(record.getSubmittime() != null) WHERE("submittime = #{submittime}");
            }
        }}.toString();
    }

    public String insert(DajuanitemModel record){
        return new SQL(){{
            INSERT_INTO(tableName);
            if(record != null){
                if(record.getShijuanid() != null) VALUES("shijuanid","#{shijuanid}");
                if(record.getDaan() != null) VALUES("daan","#{daan}");
                if(record.getDefen() != null) VALUES("defen","#{defen}");
                if(record.getFenshu() != null) VALUES("fenshu","#{fenshu}");
                if(record.getId() != null) VALUES("id","#{id}");
                if(record.getQtype() != null) VALUES("qtype","#{qtype}");
                if(record.getStno() != null) VALUES("stno","#{stno}");
                if(record.getTihao() != null) VALUES("tihao","#{tihao}");
                if(record.getSubmittime() != null) VALUES("submittime","#{submittime}");
            }
        }}.toString();
    }

    public String update(DajuanitemModel record){
        return new SQL(){{
            UPDATE(tableName);
            if(record != null){
                if(record.getShijuanid() != null) WHERE("shijuanid = #{shijuanid}");
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getStno() != null) WHERE("stno = #{stno}");
                if(record.getDaan() != null) SET("daan = #{daan}");
                if(record.getDefen() != null) SET("defen = #{defen}");
                if(record.getFenshu() != null) SET("fenshu = #{fenshu}");
                if(record.getQtype() != null) SET("qtype = #{qtype}");
                if(record.getTihao() != null) SET("tihao = #{tihao}");
                if(record.getSubmittime() != null) SET("submittime = #{submittime}");
            }
        }}.toString();
    }

    public String selectAll(DajuanitemModel record){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            if(record != null){
                if(record.getId() != null) WHERE("id = #{id}");
                if(record.getStno() != null) WHERE("stno = #{stno}");
                if(record.getShijuanid() != null) WHERE("shijuanid = #{shijuanid}");
                if(record.getDaan() != null) WHERE("daan = #{daan}");
                if(record.getDefen() != null) WHERE("defen = #{defen}");
                if(record.getFenshu() != null) WHERE("fenshu = #{fenshu}");
                if(record.getQtype() != null) WHERE("qtype = #{qtype}");
                if(record.getTihao() != null) WHERE("tihao = #{tihao}");
                if(record.getSubmittime() != null) WHERE("submittime = #{submittime}");
            }
        }}.toString();
    }

    public String selectAllXuanze(DajuanitemModel record){
        return new SQL(){{
            SELECT("dajuanitem.*,xuanze.* , xuanze.daan correct");
            FROM(tableName);
            if(record != null){
                if(record.getShijuanid() != null) WHERE("dajuanitem.shijuanid = #{shijuanid}");
                if(record.getStno() != null) WHERE("dajuanitem.stno = #{stno}");
                WHERE("dajuanitem.qtype = #{qtype}");
                JOIN( "xuanze on dajuanitem.tihao = xuanze.id ");
            }
        }}.toString();
    }

    public String selectAllPanduan(DajuanitemModel record){
        return new SQL(){{
            SELECT("dajuanitem.*,panduan.* ,panduan.daan correct");
            FROM(tableName);
            if(record != null){
                if(record.getShijuanid() != null) WHERE("dajuanitem.shijuanid = #{shijuanid}");
                if(record.getStno() != null) WHERE("dajuanitem.stno = #{stno}");
                WHERE("dajuanitem.qtype = #{qtype}");
                JOIN( "panduan on dajuanitem.tihao = panduan.id ");
            }
        }}.toString();
    }

    public String selectAllTiankong(DajuanitemModel record){
        return new SQL(){{
            SELECT("dajuanitem.*,tiankong.* ,tiankong.daan correct");
            FROM(tableName);
            if(record != null){
                if(record.getShijuanid() != null) WHERE("dajuanitem.shijuanid = #{shijuanid}");
                if(record.getStno() != null) WHERE("dajuanitem.stno = #{stno}");
                WHERE("dajuanitem.qtype = #{qtype}");
                JOIN( "tiankong on dajuanitem.tihao = tiankong.id ");
            }
        }}.toString();
    }

    public String selectAllJianda(DajuanitemModel record){
        return new SQL(){{
            SELECT("dajuanitem.*,jianda.* ,jianda.daan correct");
            FROM(tableName);
            if(record != null){
                if(record.getShijuanid() != null) WHERE("dajuanitem.shijuanid = #{shijuanid}");
                if(record.getStno() != null) WHERE("dajuanitem.stno = #{stno}");
                WHERE("dajuanitem.qtype = #{qtype}");
                JOIN( "jianda on dajuanitem.tihao = jianda.id ");
            }
        }}.toString();
    }
}
