package com.kaifamiao.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NoAnswerModel implements Serializable {

    private String starttime;

    private String title;

    private String name;

    private Boolean dstate;

    private Integer shijuanid;
}
