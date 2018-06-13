package com.zime.mvcdemo.dao;

import com.zime.mvcdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO
{
    public List<Customer> getCriteriaCustomer(CriteriaCustomer criteriaCustomer);//查询带条件的会员信息
    public void update(Customer customer);//修改一个会员的信息
    public void delete(Integer id);//根据ID删除一个会员
    public void add(Customer customer);//加入一个会员
    public long getCountWithName(String name);//查询相同名字的会员个数
    public Customer get(Integer id);//根据ID得到一个会员
    public List<Customer> getAll();//得到所有会员
}
