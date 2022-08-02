package com.kaifamiao.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ShijuanList implements Serializable {

    private List<Zujuan> zujuans;

    /**
     * 数据库中的title
     */
    private String shijuanname;

    private Integer total;

    private String tno;

    private List<String> date;
}
