<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit user</title>
</head>
<body>
<%@page import="org.btm.curdApp.EmpDao,org.btm.curd.Emp"%>  
  
<%  
String id=request.getParameter("id");  
Emp e=EmpDao.getEmployeeById(Integer.parseInt(id));  
%>  
<h1>Edit Form</h1>  
<form action="edituser.jsp" method="post"> 
<tr><td></td><td><input type="hidden" name="id" value="<%=e.getId() %>"/></td></tr> 
<table>
 <tr><td>Employee_code:</td><td>
 <input type="text" name="employee_code" value="<%=e.getEmployee_code() %>"/></td></tr>  
 <tr><td>Email_Id:</td><td>
 <input type="email_id" name="email_id" value="<%=e.getEmail_Id()%>"/></td></tr> 
 <tr><td>Contact_No:</td><td>
 <input type="contact_no" name="contact_no" value="<%=e.getContact_No()%>"/></td></tr>
 <tr><td>Reporting_Manager:</td><td>
 <input type="text" name="reporting_manager" value="<%=e.getReporting_Manager()%>"/></td></tr>  
 <tr><td>Status:</td><td>
 <input type="text" name="status" value="<%=e.getStatus()%>"/></td></tr> 
<tr><td>Date_Of_Joining:</td><td>
<input type="date_of_joining" name="date_of_joining" value="<%=e.getDate_Of_Joining()%>"/></td></tr> 
<tr><td>Date_Of_Resigning:</td><td>
<input type="date_of_resigning" name="date_of_resigning" value="<%=e.getDate_Of_Resigning()%>"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
</body>
</html>