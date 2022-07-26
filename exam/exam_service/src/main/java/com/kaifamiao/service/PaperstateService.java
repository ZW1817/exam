package com.kaifamiao.service;

import com.kaifamiao.model.ShijuanModel;

import java.util.List;
import java.util.Map;

public interface PaperstateService {
    List<Map<String, Object>> selectStdudent();

    Integer createShijuan(ShijuanModel shijuanModel);
}
