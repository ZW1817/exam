package com.kaifamiao.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @TableName banji
 */
@Data
public class BanjiModel implements Serializable {
    /**
     * 
     */
    private Integer id;


    private String name;


    private String tno;

    private static final long serialVersionUID = 1L;

    private String teachername;
}