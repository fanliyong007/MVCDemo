package com.zime.mvcdemo.dao;

public class CriteriaCustomer
{
    private String name;
    private String address;
    private String phone;

    public CriteriaCustomer()
    {
    }

    public CriteriaCustomer(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName()
    {
        return name==null?"%%":"%"+name+"%";
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address==null?"%%":"%"+address+"%";
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone==null?"%%":"%"+phone+"%";
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
