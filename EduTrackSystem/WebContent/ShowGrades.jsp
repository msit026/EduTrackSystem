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
<title>Show Grades</title>
</head>
<body>

	<%
		ResultSet rs = (ResultSet) request.getAttribute("showGrades");
		boolean flag = true;
	%>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Course Name</th>
			<th>Grades</th>
		</tr>
		<%
			while (rs.next()) {
				flag = false;
		%>
		<tr>
			<td><%=rs.getString("scd_student_id")%></td>
			<td><%=rs.getString("sd_name")%></td>
			<td><%=rs.getString("cd_name")%></td>
			<td><%=rs.getString("scd_grades")%></td>
		</tr>
		<%
			}
			if (flag) {
		%>
		<tr>
			<td colspan=3>No Grades are to Display On this Student</td>
		</tr>
		<%
		response.setHeader("Refresh", "3; URL=ShowGrades.html");
			}
			rs.close();
			
		%>

	</table>
</body>
</html>