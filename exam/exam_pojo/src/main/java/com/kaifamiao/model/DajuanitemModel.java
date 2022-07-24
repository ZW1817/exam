package com.kaifamiao.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * 
 * @TableName dajuanitem
 */
@Data
public class DajuanitemModel implements Serializable {
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

    private static final long serialVersionUID = 1L;
}