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
select * from reg;
</sql:query>
<table border="3">
<tr>
<th>Person Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Address</th>
<th>Email</th>
<th>Password</th>
<th>Mobile-No</th>
<th>Gender</th>
<tr>
<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.id}"/></td>
<td><c:out value="${table.fname}"/></td>
<td><c:out value="${table.lname}"/></td>
<td><c:out value="${table.Address}"/></td>
<td><c:out value="${table.Email}"/></td>
<td><c:out value="${table.password}"/></td>
<td><c:out value="${table.mobile_no}"/></td>
<td><c:out value="${table.gender}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>