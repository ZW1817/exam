package com.kaifamiao.service.Impl;

import com.kaifamiao.config.SpringConfig;
import com.kaifamiao.service.PaperstateService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class PaperstateServiceImplTest extends TestCase {

    @Autowired
    private PaperstateService paperstateService;
    @Test
    public void testSelectStdudent() {
        System.out.println(paperstateService.selectStdudent());
    }
}