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

    }

    @Override
    public void delete(Integer id)
    {

    }

    @Override
    public void add(Customer customer)
    {

    }

    @Override
    public int getCountWithName(String name)
    {
        return 0;
    }

    @Override
    public Customer get(Integer id)
    {
        return null;
    }

    @Override
    public List<Customer> getAll()
    {
        return null;
    }
}
