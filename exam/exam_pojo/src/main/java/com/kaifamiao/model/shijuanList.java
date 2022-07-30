package com.kaifamiao.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class shijuanList implements Serializable {

    private List<Zujuan> zujuans;

    /**
     * 数据库中的title
     */
    private String shijuanname;

    private Integer total;

    private String tno;
}
