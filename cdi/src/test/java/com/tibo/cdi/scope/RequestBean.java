package com.tibo.cdi.scope;

import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

@RequestScoped
public class RequestBean extends BaseBean implements Serializable {
}
