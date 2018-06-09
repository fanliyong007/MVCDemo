package com.zime.mvcdemo.test;

import com.zime.mvcdemo.db.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class JdbcUtilsTest
{

    @Test
    public void getConnection() throws SQLException
    {
        Connection connection=JdbcUtils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void releaseConnection()
    {

    }
}