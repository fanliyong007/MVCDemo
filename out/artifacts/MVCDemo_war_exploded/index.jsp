<%@page import="com.zime.mvcdemo.entity.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="Scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			var name=$(this).parent().parent().find("td:eq(1)").text();
			var flag=confirm("确定要删除"+name+"吗?");
			return flag;
		});
	});
</script>
</head>
<body>
	<form action="query.do" method="post">
		Name:<input type="text" name="name"/><br>
		Address:<input type="text" name="address"/><br>
		Phone:<input type="text" name="phone"/><br>
		<br>
		<input type="submit" value="查询">
		<a href="addCustomer.jsp">添加一个新的会员</a>
	</form>
	<br><br>
	<hr>
	<br>
	<%
		List<Customer> customers=(List<Customer>)request.getAttribute("customers");
		if(customers!=null&&customers.size()>0){
	%>
	
	<table	border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Operate</th>
		</tr>
		<%
			for(Customer customer:customers){
		%>
		<tr>
			<td><%=customer.getId() %></td>
			<td><%=customer.getName() %></td>
			<td><%=customer.getAddress() %></td>
			<td><%=customer.getPhone() %></td>
			<td>
				<a href="edit.do?id=<%=customer.getId()%>">UPDATE</a>
				<a href="delete.do?id=<%=customer.getId()%>" class="delete">DELETE</a>			
			</td>
		</tr>
	<%
			}
	%>
	</table>
	<%
		}
	%>
</body>
</html>