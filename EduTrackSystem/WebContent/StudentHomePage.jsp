
<%
	if (session.getAttribute("userType") == null) {
		response.sendRedirect("Logout");
	} else {
%>

<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="EN" xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN"
	dir="ltr">
<head profile="http://gmpg.org/xfn/11">
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=iso-8859-1" />
<title>Student Home Page</title>
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
</head>
<body id="top">
	<div class="wrapper col1">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">LC Solutions</a>
				</h1>
				<p>
					<strong>Helping you build your dream</strong>
				</p>
			</div>
			<br class="clear" />
		</div>
	</div>
	<div class="wrapper col2">
		<div id="topbar">
			<div style="width: 100%; float: right;" id="topnav">
				<ul style="width: 100%; float: right">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="ShowCoursesServelt">View Courses</a></li>
					<li><a href="#">View Result</a></li>
					<li><a href="#">View feedback</a></li>
					<li><a href="EditProfilePage.jsp">Edit Profile</a></li>
					<li style="float: right"><a href="Logout">Logout</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>
	<div class="wrapper col4">
		<div id="container">
			<div id="content">
				<h1>Notifications</h1>
				<form name="feedback" action="ShowFeedBackServlet">
					<ul>
						<%
							ResultSet rs = (ResultSet) request
										.getAttribute("feedBackNotificationsResultSet");
								while (rs.next()) {
						%>
						<li><%=rs.getString("mf_mentor_name")%> has sent you a
							feedback with title <%=rs.getString("mf_title")%></li>
						<%
							}
						%>
						<input type="submit" id="buttonSubmit" name="buttonSubmit"
							value="Show pending requests">
				</form>
				</ul>
			</div>
		</div>
		<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" />
		<div class="wrapper col7">
			<div id="copyright">
				<p class="fl_left">
					Copyright � 2014 - All Rights Reserved - <a href="#">MSITMedhas</a>
				</p>
				<br class="clear" />
			</div>
		</div>
	</div>
</body>
</html>
<%
	}
%>
