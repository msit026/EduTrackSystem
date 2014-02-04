
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pending Requests</title>
</head>
<body>
	<form action="Approve" method="get">

			<%
				boolean flag = true;
				ResultSet rs = (ResultSet) request.getAttribute("studentRequests");
			%>
			<table name="showRequest">
			<tr>
				<th>Select</th>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Program</th>
				<th>Admitted Year</th>

			</tr>
			<%
				while (rs.next()) {
					flag = false;
			%>
			<tr>
				<td><input type="checkbox"
					name="checkedRows"
					value="<%=rs.getString("sd_student_id")%>" /></td>
					<td><%=rs.getString("sd_student_id")%></td>
				<td><%=rs.getString("sd_name")%></td>
				<td><%=rs.getString("sd_program")%></td>
				<td><%=rs.getString("sd_admitted_year")%></td>
			</tr>
			<%
				}
				if (flag) {
			%>
			<tr>
				<td colspan=4>No Details are there to display</td>
			<tr>
				<%
					}
					rs.close();
				%>
			<tr>
				<td colspan=5>
					<center>
						<input type="submit" name="Submit" Value="Approve" />
					</center>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>