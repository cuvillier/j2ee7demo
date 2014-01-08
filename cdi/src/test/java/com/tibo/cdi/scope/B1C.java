package com.tibo.cdi.scope;

import org.junit.Assert;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ConversationScoped
public class B1C implements Serializable {

    @Inject
    private B1R bean;

    public void validate() {
        Assert.assertNotEquals(B1R.class, bean.getClass());
        bean.validate();
    }
}
