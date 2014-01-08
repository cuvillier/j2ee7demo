package com.tibo.cdi;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.weld.context.RequestContext;
import org.jboss.weld.context.bound.BoundRequestContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Conversation;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thibault on 1/6/14.
 */
@RunWith(Arquillian.class)
public class BaseTestCDI {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTestCDI.class);

    @Deployment(testable = true)
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, BaseTestCDI.class.getPackage())
                .addAsManifestResource("META-INF/beans.xml", ArchivePaths.create("beans.xml"));
    }

    @Inject
    private BoundRequestContext requestContext;

    protected Map<String, Object> requestDataStore;

    public void startRequest() {
        requestDataStore = new HashMap<>();
        requestContext.associate(requestDataStore);
        requestContext.activate();
    }

    public void endRequest() {
        try {
//            requestContext.invalidate();
//            requestContext.deactivate();
        } finally {
//            requestContext.dissociate(requestDataStore);
        }
    }
}
