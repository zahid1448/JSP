<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view user</title>
</head>
<body>
<%@page import="org.btm.curdApp.EmpDao,org.btm.curd.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<h1>Employees List</h1>  
<%  
List<Emp> list=EmpDao.getAllEmployees();  
request.setAttribute("list",list);  
%>  
<table border="1" width="90%">  
<tr><th>id</th><th>Employee_code</th><th>Email_Id</th><th>Contact_No</th><th>Reporting_Manager</th>
<th>Status</th><th>Date_Of_Joining</th><th>Date_Of_Resigning</th><th>Edit</th><th>Delete</th></tr> 
<c:forEach items="${list}" var="e">  
<tr><td>${e.getId()}</td><td>${e.getEmployee_code()}</td><td>${e.getEmail_Id()}</td>  
<td>${e.getContact_No()}</td><td>${e.getReporting_Manager()}</td><td>${e.getStatus()}</td> <td>${e.getDate_Of_Joining()}</td>
<td>${e.getDate_Of_Resigning()}</td>  
<td><a href="editform.jsp?id=${e.getId()}">Edit</a></td>  
<td><a href="deleteuser.jsp?id=${e.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  
<br/><a href="adduserform.jsp">Add New User</a>  
</body>
</html>