package com.tibo.vsn;

import org.apache.log4j.BasicConfigurator;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 * Created by Thibault on 12/18/13.
 */
@RunWith(Arquillian.class)
public abstract class BaseTest {

    @BeforeClass
    public static void before() {
//        BasicConfigurator.configure();
    }
}
