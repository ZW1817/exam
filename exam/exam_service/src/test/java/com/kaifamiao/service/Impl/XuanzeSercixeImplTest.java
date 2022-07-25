package com.kaifamiao.service.Impl;

import com.kaifamiao.config.SpringConfig;
import com.kaifamiao.model.XuanzeModel;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class XuanzeSercixeImplTest extends TestCase {

    @Autowired
    private XuanzeSercixeImpl xuanzeSercixe;

    @Test
    public void testSelectRandNum() {
        List<XuanzeModel> list = xuanzeSercixe.selectRandNum(11);
        System.out.println(list.size());
        System.out.println(list);
    }
}