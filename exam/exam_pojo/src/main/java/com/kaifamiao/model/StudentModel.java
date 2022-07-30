package com.kaifamiao.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@Data
public class StudentModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String stno;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private Date birthday;

    private String des;

    private String jiguan;

    private String mianmao;

    private String tell;

    private String name;

    private String nation;

    private String password;

    private String photo;


    private String sex;


    private String zhuanye;

    private Integer classid;

    private String classname;

    private static final long serialVersionUID = 1L;
}