package com.tibo.cdi.scope;

import com.tibo.cdi.BaseTestCDI;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.UserTransaction;
import java.lang.reflect.Proxy;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScopeTest extends BaseTestCDI {

    @Inject
    private Instance<ApplicationBean> applicationInstance;

    @Inject
    private Instance<SingletonBean> singletonInstance;

    @Inject
    private Instance<RequestBean> requestInstance;

    @Inject
    private Instance<SessionBean> sessionInstance;

    @Inject
    private Instance<TransactionBean> transactionInstance;

    @Inject
    private Instance<NoScopeBean> noScopeInstance;

    @Inject
    private BeanManager beanManager;

    @Test
    public void testApplication() {

        NoScopeBean noScope1 = noScopeInstance.get();
        NoScopeBean noScope2 = noScopeInstance.get();
        Assert.assertNotEquals(noScope1, noScope2);

        SingletonBean singleton1 = singletonInstance.get();
        SingletonBean singleton2 = singletonInstance.get();
        Assert.assertEquals(singleton1, singleton2);

        ApplicationBean application1 = applicationInstance.get();
        ApplicationBean application2 = applicationInstance.get();
        Assert.assertEquals(application1, application2);

        TransactionBean transaction1 = transactionInstance.get();
        TransactionBean transaction2 = transactionInstance.get();
        Assert.assertEquals(transaction1, transaction2);

        RequestBean request1 = requestInstance.get();
        RequestBean request2 = requestInstance.get();
        Assert.assertEquals(request1, request2);
    }

    @Inject
    private B1A bean;

    @Inject
    private UserTransaction transaction;

    @Test
    public void testProxy() throws Exception {
        Assert.assertNotEquals(B1A.class, bean.getClass());
        bean.validate();
    }
}
