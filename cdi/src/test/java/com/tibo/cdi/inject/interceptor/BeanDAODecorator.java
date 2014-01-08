package com.tibo.cdi.inject.interceptor;

import com.tibo.cdi.inject.alternative.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.List;

@Decorator
public class BeanDAODecorator implements BeanDAO {
    private static Logger logger = LoggerFactory.getLogger(BeanDAODecorator.class);

    @Delegate @Inject
    private BeanDAO delegate;

    @Override
    public List<String> getNames() {
        List<String> names =  delegate.getNames();
        for(String s: names) {
            logger.info(" => " + s);
        }
        return names;
    }
}
