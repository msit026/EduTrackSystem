<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!-- 
	@author Ujvala
 -->

<%
	if (session.getAttribute("userType") == null) {
		System.out.println("Here");
		response.sendRedirect("Logout");
	} else {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="EN" xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN"
	dir="ltr">
<head profile="http://gmpg.org/xfn/11">
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=iso-8859-1" />
<title>Courses Page</title>
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script>
	function showStudentId() {
		if (document.getElementById("year").value == "--select--") {
			document.getElementById('studentId').innerHTML = "";
			alert("Please select the batch");
		} else {
			var url = 'RetrieveStudents?cYear='
					+ document.getElementById("year").value + "&prediction='p'";
			var someStudents = $.get(url, function(responseText) {
				var res = responseText;
				document.getElementById('studentId').innerHTML = res;
			});
		}
	}
	function showCGPA() {
		if (document.getElementById("studentsList").value == "--select--") {
			document.getElementById('cgpa').innerHTML = "";
			alert("Please select the roll number ");
		} else {
			var url = 'RetrieveCGPA?studentNo='
					+ document.getElementById("studentsList").value;
			var someStudents = $.get(url, function(responseText) {
				var res = responseText;
				document.getElementById('cgpa').innerHTML = res;
			});
		}
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
					<li class="active"><a href="adminHomePage.jsp">Home</a></li>
					<li><a href="fileUploadPage.jsp">Upload Files</a></li>
					<li><a href="#">Approve User</a>
						<ul>
							<li><a href="ShowPendingRequestsServlet">Students</a></li>
							<li><a href="ShowMentorsPendingRequestsServlet">Mentors</a></li>
						</ul></li>
					<!--      <li><a href="#">Edit Profile</a></li>     -->

					<li><a href="#">View Data</a>
						<ul>
							<li><a href="ShowRegisteredStudentsServlet">Registered
									Students</a></li>
							<li><a href="ShowUnRegisteredStudentsServlet">Unregistered
									Students</a></li>
							<li><a href="ShowCoursesServelt">Courses</a></li>
							<li><a href="ShowGradesServlet">Grades</a></li>
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
					<li class="active"><a href="PredictionTool.jsp">Predict CGPA</a></li>
					<li ><a href="Feedbackjsp.jsp">Give feedback</a></li>
					<li><a href="ViewFeedback.jsp">View Feedback</a></li>
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

				<form action=EstimateCGPA>
					<center>
						<table style="width: 378px; height: 83px;">
							<tbody>
								<tr>
									<td style="font-size:12px; color:black">Batch:</td>
									<td><select name="year" id="year"
										onchange="showStudentId()">
											<option>--select--</option>
											<option value='2012'>2012</option>
											<option value='2013'>2013</option>
									</select></td>

								</tr>
								<tr name='studentId' id='studentId' required="required">
								</tr>
							</tbody>
						</table>
						<span name='cgpa' id='cgpa' required="required"></span>
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