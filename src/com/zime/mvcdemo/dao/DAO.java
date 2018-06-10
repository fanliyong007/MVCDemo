package com.zime.mvcdemo.dao;
/**
 * 封装了基本的CRUB（增删该查）方法，以提供子类继承使用
 * <T> 当前DAO要处理的实体类的类型
 */

import com.zime.mvcdemo.db.JdbcUtils;
import com.zime.mvcdemo.utils.ReflectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DAO<T>
{
    /*
        返回对于的T的一个实体类对象
     */
    private Class<T> clazz;
    private QueryRunner qr = new QueryRunner();
    public DAO()
    {
        clazz = ReflectionUtils.getSuperGenericType(getClass());
    }

    public T get(String sql, Object... args)
    {
        Connection connection = null;
        try
        {
            connection = JdbcUtils.getConnection();
            return qr.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally
        {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }
    /**
     * 返回T对应的List
     *
     * @param sql
     * @param args
     * @return
     */
    public List<T> getForList(String sql, Object... args)
    {
        Connection connection = null;
        try
        {
            connection = JdbcUtils.getConnection();
            return qr.query(connection, sql, new BeanListHandler<>(clazz), args);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    /**
     * 返回某一个字段的值，suchas：返回某一条记录的会员名或者是使用聚集函数比如会员数 count(*)
     *
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql, Object... args)
    {
        Connection connection = null;
        try
        {
            connection = JdbcUtils.getConnection();
            return (E) qr.query(connection, sql, new ScalarHandler(), args);
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally
        {
            JdbcUtils.releaseConnection(connection);
        }
        return null;
    }

    /*
    封装insert，delete，update操作
    @param sql SQL语句
    @param args 填充SQL语句中的点位符的参数值
     */
    public void update(String sql, Object... args)
    {
        Connection connection = null;
        try
        {
            connection = JdbcUtils.getConnection();
            qr.update(connection, sql, args);
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally
        {
            JdbcUtils.releaseConnection(connection);
        }

    }
}
