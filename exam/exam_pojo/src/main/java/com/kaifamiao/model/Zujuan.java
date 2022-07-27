package com.kaifamiao.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Zujuan implements Serializable {

    private Integer qtype;


    /**
     * 科目名
     */
    private String title;

    private Integer tnum;

    private Integer score;
}
