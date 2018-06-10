package com.zime.mvcdemo.test;

import com.zime.mvcdemo.dao.CustomerDAO;
import com.zime.mvcdemo.entity.Customer;
import com.zime.mvcdemo.impl.CustomerDAOJdbcImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerDAOJdbcImplTest
{
    private CustomerDAO customerDAO=new CustomerDAOJdbcImpl();
    @Test
    public void update()
    {

    }

    @Test
    public void delete()
    {
    }

    @Test
    public void add()
    {

    }

    @Test
    public void getCountWithName()
    {
        long a=customerDAO.getCountWithName("xiaoming");
        System.out.println(a);
    }

    @Test
    public void get()
    {

    }

    @Test
    public void getAll()
    {

    }
}