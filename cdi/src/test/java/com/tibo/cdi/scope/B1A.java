package com.tibo.cdi.scope;

import org.junit.Assert;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class B1A {

    @Inject
    private B1C bean;

    public void validate() {
        Assert.assertNotEquals(B1C.class, bean.getClass());
        bean.validate();
    }
}
