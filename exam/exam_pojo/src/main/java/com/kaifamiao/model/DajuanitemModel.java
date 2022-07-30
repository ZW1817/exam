package com.kaifamiao.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName dajuanitem
 */
@Data
public class DajuanitemModel implements Serializable {

    private List<DajuanitemModel> papers;
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String daan;

    /**
     *
     */
    private Integer shijuanid;

    /**
     *
     */
    private Integer defen;


    private Integer tihao;

    /**
     * 
     */
    private Integer qtype;

    /**
     * 
     */
    private Integer fenshu;

    /**
     * 
     */
    private String stno;
    private Date submittime;

    private String title;

    private String choicea;

    private String choiceb;

    private String choicec;

    private String choiced;

    private String correct;

    private static final long serialVersionUID = 1L;
}