package com.kaifamiao.service.Impl;

import com.kaifamiao.config.SpringConfig;
import com.kaifamiao.model.BanjiModel;
import com.kaifamiao.service.BanjiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BanjiServiceImplTest {

    @Autowired
    private BanjiService banjiService;

    @Test
    public void insert(){
        BanjiModel banji = new BanjiModel();
        banji.setName("计算机一班");
        banji.setTno("T001");
//        System.out.println(banjiService.insert(banji));
        System.out.println(banjiService.selectByid(2));
    }
}