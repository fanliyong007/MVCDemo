package com.zime.mvcdemo.impl;

import com.zime.mvcdemo.dao.CustomerDAO;
import com.zime.mvcdemo.dao.DAO;
import com.zime.mvcdemo.entity.Customer;

import java.util.List;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO
{

    @Override
    public void update(Customer customer)
    {
        String sql="UPDATE customers SET name=?,address=?,phone=? WHERE id=?";
        update(sql,customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());
    }

    @Override
    public void delete(Integer id)
    {
        String sql="DELETE FROM customers WHERE id=?";
        update(sql,id);
    }

    @Override
    public void add(Customer customer)
    {
        String sql="INSERT INTO customers(name,address,phone) VALUES(?,?,?)";
        update(sql,customer.getName(),customer.getAddress(),customer.getPhone());
    }

    @Override
    public long getCountWithName(String name)
    {
        String sql="SELECT count(*) FROM customers WHERE name=?";
        return getForValue(sql,name);
    }

    @Override
    public Customer get(Integer id)
    {
        String sql="SELECT id,name,address,phone FROM customers WHERE id=?";
        return get(sql,id);
    }

    @Override
    public List<Customer> getAll()
    {
        String sql="SELECT id,name,address,phone FROM customers";
        return getForList(sql);
    }
}
