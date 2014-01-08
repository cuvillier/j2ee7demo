package com.tibo.cdi.inject.interceptor;

import com.tibo.cdi.BaseTestCDI;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;

public class TestInterceptor extends BaseTestCDI {

    @Inject
    private BeanDAO bean;

    @Test
    public void interceptor() {
        Assert.assertNotNull(bean);
        for(int i = 0 ; i < 10; i++ ) {
            bean.getNames();
        }
    }
}
