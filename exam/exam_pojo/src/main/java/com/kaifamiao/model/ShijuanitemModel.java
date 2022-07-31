package com.kaifamiao.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName shijuanitem
 */
@Data
public class ShijuanitemModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer fenshu;

    /**
     * 
     */
    private Integer shijuanid;

    /**
     * 
     */
    private Integer tihao;

    /**
     * 
     */
    private Integer qtype;

    private String title;

    private String choicea;

    private String choiceb;

    private String choicec;

    private String choiced;

    private String daan;

//    学生答案
    private String choice;
    private String panduan;
    private String tiankong;
    private String jianda;

    private static final long serialVersionUID = 1L;
}