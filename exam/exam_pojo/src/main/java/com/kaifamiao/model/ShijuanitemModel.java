package com.kaifamiao.model;

import java.io.Serializable;
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

    private static final long serialVersionUID = 1L;
}