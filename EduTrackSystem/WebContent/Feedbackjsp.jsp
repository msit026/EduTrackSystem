<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%
	if (session.getAttribute("userType") == null) {
		response.sendRedirect("Logout");
	} else {
%>

<html>
<head profile="http://gmpg.org/xfn/11">

<!--Load the AJAX API-->
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	function showStudents() {
		var url = 'RetrieveStudents?cYear='
				+ document.getElementById("year").value;
		
		var someStudents = $.get(url, function(responseText) {
			var res = responseText;
			document.getElementById('studentId').innerHTML = res;
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
					<li class="active"><a href="MentorHomePage.jsp">Home</a></li>
					<li><a href="#">View Reports</a>
						<ul>
							<li><a
								href="http://localhost:80/phpFiles/CourseMarksGraph.html">year
									Wise Student Report</a></li>
							<li><a href="http://localhost/phpFiles/gradeAnalysis.html">Overall
									Performance Grade Wise </a></li>
							<li><a href="http://localhost/phpFiles/gradesAjax.html">Overall
									Performance Course Wise </a></li>
							<li><a href="http://localhost/phpFiles/rollNumberAjax.html">Course
									Wise Student Report</a></li>
							<li><a
								href="http://localhost/phpFiles/studentGradesForCourse.html">Batch
									Analysis Course Wise</a></li>
							<li><a
								href="http://localhost/phpFiles/studentsCGPAGraph.html">Batch
									Wise CGPA Analysis</a></li>
						</ul></li>
					<li><a href="PredictionTool.jsp">Predict CGPA</a></li>
					<li><a href="Feedbackjsp.jsp">Give feedback</a></li>
					<li><a href="ViewFeedback.jsp">View feedback</a></li>
					<li><a href="EditProfilePage.jsp">Edit Profile</a></li>
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
							<li><a
								href="http://localhost:80/phpFiles/CourseMarksGraph.html">year
									Wise Student Report</a></li>
							<li><a href="http://localhost/phpFiles/gradeAnalysis.html">Overall
									Performance Grade Wise </a></li>
							<li><a href="http://localhost/phpFiles/gradesAjax.html">Overall
									Performance Course Wise </a></li>
							<li><a href="http://localhost/phpFiles/rollNumberAjax.html">Course
									Wise Student Report</a></li>
							<li><a
								href="http://localhost/phpFiles/studentGradesForCourse.html">Batch
									Analysis Course Wise</a></li>
							<li><a
								href="http://localhost/phpFiles/studentsCGPAGraph.html">Batch
									Wise CGPA Analysis</a></li>
						</ul></li>
					<li><a href="PredictionTool.jsp">Predict CGPA</a></li>
					<li class="active"><a href="Feedbackjsp.jsp">Give feedback</a></li>
					<li><a href="ViewFeedback.jsp">View feedback</a></li>
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
					
					
	<center>
	<form name="feedbackForm" action="FeedbackServlet">
		<table>
			<tr>
				<td> <label for='year' style="color:black; font-size:12px">Year : </label></td>
				<td><select name='year' id='year' onchange="showStudents()"
					required="required">
						<option value="select">Select Year</option>
						<option value='2012'>2012</option>
						<option value='2013'>2013</option>
				</select></td>
			</tr>

			<tr name='studentId' id='studentId' required="required">

			</tr>

			<tr>
				<td><label for='title' id='title' style="color:black ;font-size:12px">Title : </label></td>
				<td><input type='text' name='title' id='title'
					required="required" /> <br></td>
			</tr>

			<tr>
				<td><label for='feedback' id='feedback' style="color:black;font-size:12px"> Description : </label></td>
				<td><textarea name='feedback' id='feedback' required="required"></textArea></td>
			</tr>
			<tr>
				<td colspan=2>
					<center>
						<input type="submit" id="buttonSubmit" name="buttonSubmit" value="Send Feedback">
					</center>
				</td>
			</tr>
		</table>
	</form>
</center>
				
			</div>
		</div>
		<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" />
		<div class="wrapper col7">
			<div id="copyright">
				<p class="fl_left">
					Copyright © 2014 - All Rights Reserved - <a href="#">MSITMedhas</a>
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