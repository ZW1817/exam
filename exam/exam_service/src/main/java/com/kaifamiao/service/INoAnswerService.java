package com.kaifamiao.service;
import com.kaifamiao.model.NoAnswerModel;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true,propagation = Propagation.SUPPORTS,isolation = Isolation.DEFAULT)
public interface INoAnswerService {

    List<NoAnswerModel> findAll(String stno);
}
