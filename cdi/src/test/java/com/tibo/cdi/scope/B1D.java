package com.tibo.cdi.scope;

import org.junit.Assert;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.TransactionScoped;
import java.io.Serializable;

@Dependent
public class B1D implements Serializable {
}
