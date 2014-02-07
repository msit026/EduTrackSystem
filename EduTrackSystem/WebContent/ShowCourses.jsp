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
<title>Show Courses</title>
</head>
<body>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("showCourses");
		boolean flag = true;
	%>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Credits</th>
			<th>Duration</th>
			<th>Year</th>
		</tr>
		<%
			while (rs.next()) {
				flag = false;
		%>
		<tr>
			<td><%=rs.getString("cd_course_id")%></td>
			<td><%=rs.getString("cd_name")%></td>
			<td><%=rs.getString("cd_credits")%></td>
			<td><%=rs.getString("cd_duration")%></td>
			<td><%=rs.getString("cd_course_year")%></td>
		</tr>
		<%
			}
			if (flag) {
		%>
		<tr>
			<td colspan=3>No Courses are to Display</td>
		<tr>
			<%
			response.setHeader("Refresh", "3; URL=ShowCourses.html");
				}
			rs.close();
			
			%>
		
	</table>
</body>
</html>