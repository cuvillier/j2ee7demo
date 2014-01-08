package com.tibo.cdi.scope;

import org.junit.Assert;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;

@RequestScoped
public class B1R implements Serializable {
    @Inject
    private B1D bean;

    public void validate() {
        Assert.assertEquals(B1D.class, bean.getClass());
    }
}
