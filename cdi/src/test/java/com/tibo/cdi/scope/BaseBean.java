package com.tibo.cdi.scope;

public class BaseBean {
    private static int counter = 0;
    private int number = counter++;

    public int getNumber() {
        return number;
    }
}
