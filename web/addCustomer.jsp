<%--
  Created by IntelliJ IDEA.
  User: fanliyong
  Date: 2018/6/13
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>addCustomer</title>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
</head>
<body>
<%
    Object msg=request.getAttribute("msg");
    if(msg!=null)
    {
%>
    <br>
    <font color="red"><%=msg%></font>
    <br>
<%
    }
%>
<form action="add.do" method="post">
    Name:<input type="text" name="name"
                value="<%=request.getParameter("name")==null?"":request.getParameter("name")%>"/><br>
    Address:<input type="text" name="address"
                   value="<%=request.getParameter("address")==null?"":request.getParameter("address")%>"/><br>
    Phone:<input type="text" name="phone"
                 value="<%=request.getParameter("phone")==null?"":request.getParameter("phone")%>"/><br>
    <br>
    <input type="submit" value="添加">
</form>
<br><br>
</body>
</html>
