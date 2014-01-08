package com.tibo.cdi.inject.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.Interceptors;
import java.io.FileReader;
import java.util.*;

public class BeanDAOImpl extends BeanDAOBase {
    private static final Logger logger = LoggerFactory.getLogger(BeanDAOImpl.class);

    private Random random = new Random(System.currentTimeMillis());

    @Override
    @Performance(log = false, alarm = 300)
    public List<String> getNames() {
        try {
            long duration = 100 + random.nextInt(400);
            logger.info("Waiting for " + duration + " ms");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Real code should read from a storage.
        return Arrays.asList("alice", "bob", "conrad", "dan", "erik");
    }
}
