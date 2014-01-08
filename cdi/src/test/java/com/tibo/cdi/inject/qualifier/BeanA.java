package com.tibo.cdi.inject.qualifier;

import javax.enterprise.inject.Default;

@Default
@AliceBean
@BeanName(BeanNameEnum.ALICE)
public class BeanA extends BeanBase {
}
