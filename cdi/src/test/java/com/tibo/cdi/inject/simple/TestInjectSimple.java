package com.tibo.cdi.inject.simple;

import com.tibo.cdi.BaseTestCDI;
import org.junit.Assert;
import org.junit.Test;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class TestInjectSimple extends BaseTestCDI {

    @Inject
    private BeanWithFieldInjection bwfi;

    @Inject
    private BeanWithConstructorInjection bwci;

    @Test
    public void injectBigBean() {
        Assert.assertNotNull(bwfi);
        Assert.assertNotNull(bwfi.getBeanA());
        Assert.assertNotNull(bwfi.getBeanB());

        Assert.assertNotNull(bwfi.getBeanA());
        Assert.assertNotNull(bwfi.getBeanB());
    }

    @Inject
    private Instance<BeanWithFieldInjection> bwfiInstance;

    @Test
    public void injectInstance() {
        BeanWithFieldInjection bwfi = bwfiInstance.get();
        Assert.assertNotNull(bwfi);
    }
}