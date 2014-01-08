package com.tibo.cdi.inject.alternative;

import com.tibo.cdi.BaseTestCDI;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;

public class TestAlternative extends BaseTestCDI {

    @Inject
    private BeanDAO bean;

    @Test
    public void alternative() {
        Assert.assertNotNull(bean);
        logger.info(bean.getClass().getSimpleName());
        Assert.assertEquals(bean.getClass(), BeanDAOMock.class);
    }
}
