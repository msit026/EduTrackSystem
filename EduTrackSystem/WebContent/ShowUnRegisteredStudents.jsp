
<%
	if (session.getAttribute("userType") == null) {
		response.sendRedirect("Logout");
	} else {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head profile="http://gmpg.org/xfn/11">

<!--Load the AJAX API-->
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	
<%ResultSet rs;%>
	function showStudents() {
		var url = 'ShowUnRegisteredStudentsServlet?cYear='
				+ document.getElementById("year").value;
		var someStudents = $.get(url, function(responseText) {
			var res = responseText;
			//alert(res);
			document.getElementById('details').innerHTML = res;
		});
	}
</script>


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
	<!-- Change the menu according to the user accessing the page -->

	<%
		if (session.getAttribute("userType").toString()
					.equalsIgnoreCase("admin")) {
	%>

	<div class="wrapper col2">
		<div id="topbar">
			<div style="width: 100%; float: right;" id="topnav">
				<ul style="width: 100%; float: right">
					<li><a href="adminHomePage.jsp">Home</a></li>
					<li><a href="fileUploadPage.jsp">Upload Files</a></li>
					<li><a href="#">Approve User</a>
						<ul>
							<li><a href="ShowPendingRequestsServlet">Students</a></li>
							<li><a href="ShowMentorsPendingRequestsServlet">Mentors</a></li>
						</ul></li>

					<li class="active"><a href="#">View Data</a>
						<ul>
							<li><a href="ShowRegisteredStudents.jsp">Registered
									Students</a></li>
							<li><a href="ShowUnRegisteredStudents.jsp">Unregistered
									Students</a></li>
							<li><a href="ShowRegisteredMentors">Registered Mentors</a></li>
							<li><a href="ShowUnregisteredMentors">UnRegistered
									Mentors</a></li>
							<li><a href="ShowCoursesServelt">Courses</a></li>
							<li><a href="ShowGrades.jsp">Grades</a></li>
						</ul></li>

					<li><a href="Templates.jsp">Templates</a></li>
					<li><a href="userContactUs.jsp">Contact Us</a></li>
					<li style="float: right"><a href="Logout">Logout</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>
	<%
		} else if (session.getAttribute("userType").toString()
					.equalsIgnoreCase("mentor")) {
	%>
	<div class="wrapper col2">
		<div id="topbar">
			<div style="width: 100%; float: right;" id="topnav">
				<ul style="width: 100%; float: right">
					<li><a href="MentorHomePage.jsp">Home</a></li>
					<li><a href="#">View Reports</a>
						<ul>
							<li><a href="#">Course Report</a></li>
							<li><a href="#">Student Performance</a></li>
						</ul></li>
					<li><a href="PredictionTool.jsp">Predict CGPA</a></li>
					<li class="active"><a href="#">Give feedback</a></li>
					<li><a href="#">Send Request</a></li>
					<li><a href="EditProfilePage.jsp">Edit Profile</a></li>
					<li style="float: right"><a href="Logout">Logout</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>
	<%
		} else {
	%>
	<div class="wrapper col2">
		<div id="topbar">
			<div style="width: 100%; float: right;" id="topnav">
				<ul style="width: 100%; float: right">
					<li><a href="StudentHomePage.jsp">Home</a></li>
					<li class="active"><a href="#">View Courses</a></li>
					<li><a href="#">View Result</a></li>
					<li><a href="#">View feedback</a></li>
					<li><a href="EditProfilePage.jsp">Edit Profile</a></li>
					<li style="float: right"><a href="Logout">Logout</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>
	<%
		}
	%>
	<div class="wrapper col4">
		<div id="container">
			<div id="content">

				<table>
					<tr>
						<td><label for='year' style="color: black; font-size: 12px">Year
								: </label></td>
						<td><select name='year' id='year' onchange="showStudents()"
							required="required">
								<option value="select">Select Year</option>
								<option value='2012'>2012</option>
								<option value='2013'>2013</option>
						</select></td>
					</tr>
				</table>


				<span id=details name='details'></span>

			</div>
		</div>
		<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" />	<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" />	<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
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