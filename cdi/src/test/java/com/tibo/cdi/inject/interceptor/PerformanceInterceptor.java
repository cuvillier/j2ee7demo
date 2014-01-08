package com.tibo.cdi.inject.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Performance @Interceptor
public class PerformanceInterceptor {
    private Logger logger = LoggerFactory.getLogger("performance");

    @AroundInvoke
    public Object monitorPerformance(InvocationContext ctx) throws Exception {
        logger.debug("Interceptor called");
        Performance performance = ctx.getMethod().getAnnotation(Performance.class);

        if( performance != null ) {
            long startAt = System.currentTimeMillis();
            try {
                return ctx.proceed();
            } finally {
                long endAt = System.currentTimeMillis();
                long duration = endAt - startAt;
                if( performance.log() ) logger.info(ctx.getMethod().getName() + " : " + duration + " ms");
                if( performance.alarm() > 0 && duration >= performance.alarm() ) {
                    logger.error(ctx.getMethod().getName() + " took " + duration + " ms which is over " + performance.alarm() + " ms");
                }
            }
        } else {
            return ctx.proceed();
        }
    }
}
