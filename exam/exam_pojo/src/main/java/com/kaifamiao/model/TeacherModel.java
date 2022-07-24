package com.kaifamiao.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName teacher
 */
@Data
public class TeacherModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String tno;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private String jiguan;

    /**
     * 
     */
    private String xueli;

    /**
     * 
     */
    private String photo;

    /**
     * 
     */
    private String nation;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String tell;

    /**
     * 
     */
    private String zhicheng;

    /**
     * 
     */
    private String major;

    /**
     * 
     */
    private String jieshao;

    private static final long serialVersionUID = 1L;
}