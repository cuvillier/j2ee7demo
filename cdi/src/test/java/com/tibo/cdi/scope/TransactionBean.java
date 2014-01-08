package com.tibo.cdi.scope;

import javax.transaction.TransactionScoped;
import java.io.Serializable;

@TransactionScoped
public class TransactionBean extends BaseBean implements Serializable {
}
