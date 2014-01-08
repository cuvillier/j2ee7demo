package com.tibo.cdi.inject.qualifier;

import javax.inject.Inject;

public class BeanWithConstructorInjection {
    private BeanA beanA;
    private BeanB beanB;

    @Inject
    public BeanWithConstructorInjection(BeanA beanA, BeanB beanB) {
        this.beanA = beanA;
        this.beanB = beanB;
    }

    public BeanA getBeanA() {
        return beanA;
    }

    public BeanB getBeanB() {
        return beanB;
    }
}
