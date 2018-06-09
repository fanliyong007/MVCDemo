package com.zime.mvcdemo.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC操作的工具类
 */
public class JdbcUtils
{
    /**
     * 返回数据源的一个连接Connection对象
     * @return
     */
    public static Connection getConnection()
        throws SQLException
    {
        return dataSource.getConnection();
    }

    /**
     * 释放connection连接
     * @param connection
     */
    public static void releaseConnection(Connection connection)
    {
        try
        {
            if(connection!=null)
            {
                connection.close();
                System.out.println("关闭连接成功");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("关闭连接失败");
            System.err.println(e.getMessage());
        }

    }
    private static DataSource dataSource=null;
    static
    {
        //dataSource资源只能初始化一次
        dataSource= new ComboPooledDataSource();//使用properties文件配置xml文件存在异常
        System.out.println("连接池初始化成功");
    }
}
