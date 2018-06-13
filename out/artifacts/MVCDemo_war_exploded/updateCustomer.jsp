<%@ page import="com.zime.mvcdemo.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: fanliyong
  Date: 2018/6/13
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE</title>
</head>
<%
    Object mistake = request.getAttribute("mistake");
    if (mistake != null)
    {
%>
<br>
<font color="red"><%=mistake%>
</font>
<br>
<br>
<%
    }
%>

<%
    String id = null;
    String oldName = null;
    String name = null;
    String address = null;
    String phone = null;

    Customer customer = (Customer) request.getAttribute("customer");
    if (customer != null)
    {
        id = customer.getId() + "";
        oldName = customer.getName();
        name = customer.getName();
        address = customer.getAddress();
        phone = customer.getPhone();
    }
    else
    {
        id = request.getParameter("id");
        oldName = request.getParameter("oldName");
        name = request.getParameter("name");
        address = request.getParameter("address");
        phone = request.getParameter("phone");
    }
%>
<body>
<form action="update.do" method="post">
    <input type="hidden" name="id" value="<%=id%>"/>
    <input type="hidden" name="oldName" value="<%=oldName%>"/>
    Name:<input type="text" name="name" value="<%=name%>"/><br>
    Address:<input type="text" name="address" value="<%=address%>"/><br>
    Phone:<input type="text" name="phone" value="<%=phone%>"/><br>
    <br> <input type="submit" value="更新">
</form>
</body>
</html>
