package com.tibo.cdi.inject.simple;


import javax.inject.Inject;

public class BeanWithFieldInjection {

    @Inject
    private BeanA beanA;

    @Inject
    private BeanB beanB;

    public BeanA getBeanA() {
        return beanA;
    }

    public BeanB getBeanB() {
        return beanB;
    }
}
