package com.tw.core;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

//@ContextConfiguration("classpath: web.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class ServiceTest {


    @Test
    @Rollback(true)
    public void test() throws Exception {
        assertEquals(1, 1);
    }

    @Test
    public void addOperation(){

    }
}
