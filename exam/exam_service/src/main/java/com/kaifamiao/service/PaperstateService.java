package com.kaifamiao.service;

import com.kaifamiao.model.PaperstateModel;
import com.kaifamiao.model.ShijuanModel;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public interface PaperstateService {

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
    List<Map<String, Object>> selectStudent();

    Integer createShijuan(ShijuanModel shijuanModel);

    int insert(PaperstateModel paperstate);

    int update(PaperstateModel paperstate);
}
