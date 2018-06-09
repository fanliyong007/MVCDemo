package com.zime.mvcdemo.dao;
/**
 * 封装了基本的CRUB（增删该查）方法，以提供子类继承使用
 * <T> 当前DAO要处理的实体类的类型
 */
import java.util.List;

public class DAO<T>
{
    /*
        返回对于的T的一个实体类对象
     */
    public T get(String sql,Object... args)
    {
        return null;
    }

    /**
     * 返回T对应的List
     * @param sql
     * @param args
     * @return
     */
    public List<T> getForList(String sql, Object... args)
    {
        return null;
    }

    /**
     * 返回某一个字段的值，suchas：返回某一条记录的会员名或者是使用聚集函数比如会员数 count(*)
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql,Object... args)
    {
        return null;
    }
    /*
    封装insert，delete，update操作
    @param sql SQL语句
    @param args 填充SQL语句中的点位符的参数值
     */
    public void update(String sql,Object... args)
    {


    }
}
