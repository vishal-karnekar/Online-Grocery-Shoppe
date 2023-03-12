<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>\
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/glocery" user="root" password=""/>
<sql:query dataSource="${db}" var="rs">
select * from product;
</sql:query>
<table border="3">
<tr>
<th>Id</th>
<th>Product Name</th>
<th>Quantity</th>
<th>Email</th>
<th>Address</th>
<th>Mobile-No</th>

<tr>
<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.id}"/></td>
<td><c:out value="${table.prod_name}"/></td>
<td><c:out value="${table.quantity}"/></td>
<td><c:out value="${table.Email}"/></td>
<td><c:out value="${table.Address}"/></td>
<td><c:out value="${table.mobile_no}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>