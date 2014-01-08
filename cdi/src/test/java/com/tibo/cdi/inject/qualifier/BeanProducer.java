package com.tibo.cdi.inject.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;

/**
 * Created by Thibault on 1/7/14.
 */
public class BeanProducer {
    private static final Logger logger = LoggerFactory.getLogger(BeanProducer.class);

    @Produces @BobBean @BeanName(BeanNameEnum.BOB)
    public static BeanInter produceBobBean() {
        logger.info("Producing BobBean");
        return new BeanB();
    }
}
