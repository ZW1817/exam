package com.kaifamiao.service.Impl;

import com.kaifamiao.config.SpringConfig;
import com.kaifamiao.model.DajuanitemModel;
import com.kaifamiao.model.ShijuanitemModel;
import com.kaifamiao.service.DajuanitemService;
import com.kaifamiao.service.ShijuanitemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ShijuanitemServiceImplTest {

    @Autowired
    private ShijuanitemService shijuanitemService;

    @Autowired
    private DajuanitemService dajuanitemService;

    @Test
    public void selectAllXuanze() {

        ShijuanitemModel shijuanitemModel = new ShijuanitemModel();
        shijuanitemModel.setShijuanid(1);
        shijuanitemModel.setQtype(1);

        System.out.println(shijuanitemService.selectAllPanduan(shijuanitemModel));
    }

    @Test
    public void selectAll(){
        DajuanitemModel dajuanitemModel = new DajuanitemModel();
        dajuanitemModel.setQtype(0);

        System.out.println(dajuanitemService.selectAllXuanze(dajuanitemModel));

    }
}