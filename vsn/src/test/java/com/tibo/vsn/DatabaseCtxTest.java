package com.tibo.vsn;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Thibault on 12/20/13.
 */
public class DatabaseCtxTest {
    @Test
    public void testConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection ctx = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "tibo001");
        ctx.close();
    }
}
