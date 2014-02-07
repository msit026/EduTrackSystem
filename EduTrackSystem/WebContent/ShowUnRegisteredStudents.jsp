<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*;"%>
<!-- 
	@author Mani
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UnRegistered Students Display</title>
</head>
<body>
	<%
		ResultSet rs = (ResultSet) request
				.getAttribute("unRegisteredStudentsList");
		boolean flag = true;
	%>
	<table>
		<tr>
			<th>Roll No</th>
			<th>Name</th>
			<th>Year</th>
		</tr>
		<%
			while (rs.next()) {
				flag = false;
		%>
		<tr>
			<td><%=rs.getString("sd_student_id")%></td>
			<td><%=rs.getString("sd_name")%></td>
			<td><%=rs.getString("sd_year_in_course")%></td>
		</tr>
		<%
			}
			if (flag) {
		%>
		<tr>
			<td colspan=3>No UnRegistered Students are there to display</td>
		<tr>
			<%
				}
				rs.close();
			%>
		
	</table>
</body>
</html>