
<%
	if (session.getAttribute("userType") == null) {
		response.sendRedirect("Logout");
	} else {
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="EN" xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN"
	dir="ltr">
<head profile="http://gmpg.org/xfn/11">
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=iso-8859-1" />
<title>Mentor Home Page</title>
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
	<div class="wrapper col4">
		<div id="container">
			<div id="content">
				<p>Welcome to EduTrack Portal. You can check your students'
					course wise performance, attendance and grades here. Analytic tools
					are provided to make the analysis more effective. You can suggest
					any improvements for your students through the feedback tool.</p>
			</div>
		</div>
		<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" />

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